package com.alejofila.domain

import com.alejofila.domain.model.TvShow
import io.reactivex.Single

interface TvShowsRepository{
    fun getTopTvShows(page : Int) : Single<List<TvShow>>
}