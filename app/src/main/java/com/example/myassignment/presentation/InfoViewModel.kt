package com.example.myassignment.presentation

import androidx.lifecycle.MutableLiveData
import com.example.myassignment.base.BaseViewModel
import com.example.myassignment.model.Info

class InfoViewModel : BaseViewModel() {
    private val infoTitle = MutableLiveData<String>()
    private val infoDescription = MutableLiveData<String>()
    private val infoImageHref = MutableLiveData<String>()

    fun bind(info: Info) {
        info.title?.let { infoTitle.value = it }
        info.description?.let { infoDescription.value = it }
        info.imageHref?.let {infoImageHref.value = it}
    }

    fun getInfoTitle() = infoTitle
    fun getInfoDescription() = infoDescription
    fun getInfoImageHref() = infoImageHref
}



