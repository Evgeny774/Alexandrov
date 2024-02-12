package com.example.myapplication3.screens.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication3.data.retrofit.api.RetrofitRepository
import com.example.myapplication3.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel: ViewModel() {
    private val repository = RetrofitRepository()
     val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()

    fun getMoviesRetrofit(){
        viewModelScope.launch {
            try {
                myMovies.value = repository.getMovies()
            }catch (e:Exception){
                Log.e("ERROR", e.message.toString())
            } } }
}
