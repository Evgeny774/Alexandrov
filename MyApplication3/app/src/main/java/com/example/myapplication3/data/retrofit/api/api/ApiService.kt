package com.example.myapplication3.data.retrofit.api.api

import com.example.myapplication3.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("api/v2.2/films/collections?type=TOP_POPULAR_MOVIES&page=1")
    suspend fun getPopularMovie(@Header("Accept: application/json' , X-API-KEY: e30ffed0-76ab-4dd6-b41f-4c9da2b2735b") apiKey: String = API_KEY): Response<MoviesModel>
}
const val API_KEY = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"