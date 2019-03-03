package com.example.alejofila.data.repository

import com.alejofila.domain.TvShowsRepository
import com.alejofila.domain.model.TvShow
import com.example.alejofila.data.mapper.TvShowMapper
import com.example.alejofila.data.network.TvShowsApi
import io.reactivex.Single

class TvShowsRepositoryImpl(private val tvShowsApi: TvShowsApi) : TvShowsRepository {
    override fun getTopTvShows(page: Int): Single<List<TvShow>> {
        return tvShowsApi.getPopularTvShows(page).map { it.results }
            .flattenAsObservable { it }
            .map { TvShowMapper.fromDataToDomain(it) }
            .toList()
    }

}