package com.gmribas.globoplaydesafiomobile.core.data.network

import com.gmribas.globoplaydesafiomobile.BuildConfig
import com.gmribas.globoplaydesafiomobile.core.data.dto.MovieDTO
import com.gmribas.globoplaydesafiomobile.core.data.dto.PageDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    suspend fun discoverMovies(@Query("api_key") apiKey: String = BuildConfig.API_KEY, @Query("page") page: Int, @Query("language") language: String = "pt-br"): PageDTO<MovieDTO>
}