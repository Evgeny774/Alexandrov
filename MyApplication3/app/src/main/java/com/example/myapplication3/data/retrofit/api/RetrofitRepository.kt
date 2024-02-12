package com.example.myapplication3.data.retrofit.api


import com.example.myapplication3.data.retrofit.api.api.RetrofitInstance
import com.example.myapplication3.models.MoviesModel
import retrofit2.Response


class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel>{
        return RetrofitInstance.api.getPopularMovie()
    }
}