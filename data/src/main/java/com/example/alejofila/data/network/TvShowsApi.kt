package com.example.alejofila.data.network

import com.example.alejofila.data.network.model.PopularTvShowsResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface TvShowsApi{
    @GET("tv/popular")
    fun getPopularTvShows(page: Int) : Single<List<PopularTvShowsResponse>>
}