package com.example.myassignment.network

import com.example.myassignment.model.Content
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface CanadaInfoApi {
    /**
     * Get the list of the Info from the API
     */
    @GET("/s/2iodh4vg0eortkl/facts.json")
    fun getItems(): Observable<Content>
}


