package com.example.myassignment.injection.component

import com.example.myassignment.injection.module.NetworkModule
import com.example.myassignment.presentation.InfoListViewModel
import com.example.myassignment.presentation.InfoViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified InfoListViewModel.
     * @param infoListViewModel InfoListViewModel in which to inject the dependencies
     */
    fun inject(infoListViewModel: InfoListViewModel)

    /**
     * Injects required dependencies into the specified InfoViewModel.
     * @param infoViewModel InfoViewModel in which to inject the dependencies
     */
    fun inject(infoViewModel: InfoViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}