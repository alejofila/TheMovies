package com.alejofila.domain.usecase

import com.alejofila.domain.TvShowsRepository
import com.alejofila.domain.model.TvShow
import io.reactivex.Single


interface GetPopularTvShowsUseCase{
    operator fun invoke(page: Int) : Single<List<TvShow>>
}
class GetPopularTvShowsUseCaseImpl(private val repository: TvShowsRepository) : GetPopularTvShowsUseCase{
    override fun invoke(page: Int): Single<List<TvShow>> {
        return repository.getTopTvShows(page)
    }

}