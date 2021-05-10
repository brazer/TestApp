package com.salanevich.testapp.network

import com.salanevich.testapp.model.CollectionsResponse
import com.salanevich.testapp.model.ItemDetailResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    companion object {
        val service: WebService by lazy {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://www.rijksmuseum.nl")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(WebService::class.java)
        }
    }

    @GET("/api/{culture}/collection")
    suspend fun getItems(
        @Path("culture") culture: String,
        @Query("key") key: String,
        @Query("p") page: Int,
        @Query("ps") size: Int
    ): CollectionsResponse

    @GET("/api/{culture}/collection/{object-number}")
    suspend fun getItemDetail(
        @Path("culture") culture: String,
        @Path("object-number") id: String,
        @Query("key") key: String,
    ): ItemDetailResponse

}