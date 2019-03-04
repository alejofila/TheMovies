package com.example.alejofila.themovies.populartv.presenter

import com.alejofila.domain.TvShowsRepository
import com.alejofila.domain.model.TvShow
import com.alejofila.domain.usecase.GetPopularTvShowsUseCaseImpl
import com.alejofila.newsdemo.common.TvShowUiMapper
import com.alejofila.newsdemo.common.uimodel.TvShowUiModel
import com.example.alejofila.themovies.populartv.viewcontract.PopularTvShowsView
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.hamcrest.CoreMatchers.any
import org.hamcrest.CoreMatchers.anything
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.internal.verification.VerificationModeFactory
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PopularTvShowsPresenterTest {

    @Mock
    lateinit var view :PopularTvShowsView

    @Mock
    lateinit var repository: TvShowsRepository

    private val testScheduler = TestScheduler()
    private lateinit var presenter: PopularTvShowsPresenter

    @Before
    fun setUp() {
        presenter = PopularTvShowsPresenter(GetPopularTvShowsUseCaseImpl(repository),testScheduler,testScheduler)
        presenter.view = view
    }

    @Test
    fun `when repository returns a non empty list should call showNextPageOfShows`(){
        val tvShow = TvShow("",2.2,2,"asdsad","/asdasdasd")
        val shows = listOf(tvShow)
        val singleShows = Single.just(shows)
        Mockito.`when`(repository.getTopTvShows(1)).thenReturn(singleShows)
        presenter.queryPopularTvShows()
        testScheduler.triggerActions()
        Mockito.verify(view, VerificationModeFactory.times(1))?.showNextPageOfShows(listOf(TvShowUiMapper.fromDomainToUiModel(tvShow)))
    }
    @Test
    fun `when repository returns an empty list should call showEmptyView`(){
        val singleEmptyShows = Single.just(emptyList<TvShow>())
        Mockito.`when`(repository.getTopTvShows(1)).thenReturn(singleEmptyShows)
        presenter.queryPopularTvShows()
        testScheduler.triggerActions()
        Mockito.verify(view, VerificationModeFactory.times(1))?.showEmptyView()
    }
}