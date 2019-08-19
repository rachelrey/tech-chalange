package com.example.myassignment.base

import androidx.lifecycle.ViewModel
import com.example.myassignment.injection.component.DaggerViewModelInjector
import com.example.myassignment.injection.component.ViewModelInjector
import com.example.myassignment.injection.module.NetworkModule
import com.example.myassignment.presentation.InfoListViewModel
import com.example.myassignment.presentation.InfoViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is InfoListViewModel -> injector.inject(this)
            is InfoViewModel -> injector.inject(this)
        }
    }
}