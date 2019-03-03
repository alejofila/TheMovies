package com.alejofila.domain

import io.reactivex.Single

interface TvShowsRepository{
    fun getTopTvShows(page : Int) : Single<List<TvShowsRepository>>
}