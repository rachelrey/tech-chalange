package com.example.myassignment.presentation

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.myassignment.R
import com.example.myassignment.base.BaseViewModel
import com.example.myassignment.model.ContentDao
import com.example.myassignment.model.Info
import com.example.myassignment.network.CanadaInfoApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable
import javax.inject.Inject

class InfoListViewModel(private val contentDao: ContentDao) : BaseViewModel() {
    @Inject
    lateinit var infoApi: CanadaInfoApi
    private lateinit var subscription: Disposable

    val infoListAdapter: InfoListAdapter = InfoListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    private val screenTitle = MutableLiveData<String>()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts(true) }

    init {
        loadPosts(false)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun loadPosts(showProgressBar: Boolean) {
        subscription = Observable.fromCallable {
            contentDao.content
        }
            .concatMap { content ->
                if (content.rows.isEmpty())
                    infoApi.getItems().concatMap { data ->
                        contentDao.insertContent(data)
                        Observable.just(data)
                    }
                else
                    Observable.just(content)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                if (showProgressBar) {
                    onRetrieveInfoListStart()
                }
            }
            .doOnTerminate { onRetrieveInfoListFinish() }
            .subscribe(
                { result ->
                    setScreenTitle(result.title)
                    onRetrieveInfoListSuccess(result.rows)
                },
                { onRetrieveInfoListError() }
            )
    }

    private fun onRetrieveInfoListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveInfoListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveInfoListSuccess(infoList: List<Info>) {
        infoListAdapter.updateInfoList(infoList)
    }

    private fun onRetrieveInfoListError() {
        errorMessage.value = R.string.error_message
    }

    private fun setScreenTitle(title: String) {
        screenTitle.value = title
    }

    fun getScreenTitle() = screenTitle
}