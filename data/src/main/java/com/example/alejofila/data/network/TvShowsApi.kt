package com.example.alejofila.data.network

import com.example.alejofila.data.network.model.PopularTvShowsResponse

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowsApi{
    @GET("tv/popular")
    fun getPopularTvShows(@Query("page") page: Int) : Single<PopularTvShowsResponse>
}