package com.example.alejofila.themovies.populartv.presenter

import android.util.Log
import com.alejofila.domain.usecase.GetPopularTvShowsUseCase
import com.alejofila.newsdemo.common.TvShowUiMapper
import com.alejofila.newsdemo.common.presenter.BasePresenter
import com.example.alejofila.data.network.LAST_PAGE
import com.example.alejofila.themovies.populartv.viewcontract.PopularTvShowsView
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.subscribeBy

class PopularTvShowsPresenter(
    private val useCase: GetPopularTvShowsUseCase,
    mainScheduler: Scheduler,
    backgroundScheduler: Scheduler
) :
    BasePresenter(mainScheduler = mainScheduler, backgroundScheduler = backgroundScheduler) {
    lateinit var view: PopularTvShowsView
    private var page = 1
    override fun onStart() {

    }

    fun queryPopularTvShows() {
        if (morePages()) {
            disposableBag.add(useCase(page)
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .flattenAsObservable { it }
                .map { TvShowUiMapper.fromDomainToUiModel(it) }
                .toList()
                .subscribeBy(
                    onError = {
                        Log.e("Tag","Error in presenter onSubscribe $it.message")
                        view.showServerError()
                    },
                    onSuccess = {
                        view.showNextPageOfShows(it)
                        page++
                    }

                ))
        } else {
            view.showNoMoreShowsMessage()
        }
    }

    /**
     * This is just for demo purposes, in production we should query
     * the value from PopularTvShowsResponse
     */
    fun morePages(): Boolean = page < LAST_PAGE

}