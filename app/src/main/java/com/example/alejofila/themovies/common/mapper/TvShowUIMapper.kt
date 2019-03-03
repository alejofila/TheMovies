package com.alejofila.newsdemo.common

import com.alejofila.domain.model.TvShow

import com.alejofila.newsdemo.common.uimodel.TvShowUiModel


object TvShowUiMapper {
    fun fromDomainToUiModel(tvShow: TvShow): TvShowUiModel {
        with(tvShow) {
            return TvShowUiModel(name,
                    rating,
                    coverImage
            )
        }
    }
}