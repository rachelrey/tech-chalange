package com.example.myassignment.injection.module

import com.example.myassignment.network.CanadaInfoApi
import com.example.myassignment.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required dependencies about network
 */

@Module
@Suppress("unused")
object NetworkModule {
    /**
     * Provides the service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the service implementation.
     */

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideCanadaInfoApi(retrofit: Retrofit): CanadaInfoApi {
        return retrofit.create(CanadaInfoApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}





