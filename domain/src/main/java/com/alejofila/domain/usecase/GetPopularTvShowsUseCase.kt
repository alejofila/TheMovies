package com.alejofila.domain.usecase

import com.alejofila.domain.model.TvShow
import io.reactivex.Single


interface GetPopularTvShowsUseCase{
    operator fun invoke(page: Int) : Single<List<TvShow>>
}