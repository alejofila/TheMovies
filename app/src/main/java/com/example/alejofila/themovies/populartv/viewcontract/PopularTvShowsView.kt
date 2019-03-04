package com.example.alejofila.themovies.populartv.viewcontract

import com.alejofila.newsdemo.common.uimodel.TvShowUiModel

interface PopularTvShowsView{
    fun showNextPageOfShows(shows: List<TvShowUiModel>)
    fun showNoMoreShowsMessage()
    fun showServerError()
    fun showEmptyView()
}