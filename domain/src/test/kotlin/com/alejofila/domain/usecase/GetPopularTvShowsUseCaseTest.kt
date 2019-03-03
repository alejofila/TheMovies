package com.alejofila.domain.usecase

import com.alejofila.domain.TvShowsRepository
import com.alejofila.domain.model.TvShow
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetNewsUseCaseTest {

    @Mock
    lateinit var repository: TvShowsRepository
    lateinit var getPopularTvShowsUseCase : GetPopularTvShowsUseCase

    @Before
    fun setUp() {
        getPopularTvShowsUseCase = GetPopularTvShowsUseCaseImpl(repository)
    }

    @Test
    fun `test  getting  empty  list  of  tv shows `(){
        Mockito.`when`(repository.getTopTvShows(ArgumentMatchers.anyInt())).thenReturn(Single.just(emptyList()))
        val testObserver = getPopularTvShowsUseCase(0).test()
        testObserver.assertValue{it.isEmpty()}

    }
    @Test
    fun `test getting list of multiple tv shows`() {
        val tvShow = mock(TvShow::class.java)
        val tvShow2 =  mock(TvShow::class.java)
        val list = listOf(tvShow, tvShow2)
        val page = ArgumentMatchers.anyInt()
        Mockito.`when`(repository.getTopTvShows(page)).thenReturn(Single.just(list))
        val testObserver = getPopularTvShowsUseCase(page).test()
        testObserver.assertValue{it==list}

    }
}