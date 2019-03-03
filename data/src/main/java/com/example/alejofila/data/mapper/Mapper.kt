package com.example.alejofila.data.mapper

import com.example.alejofila.data.network.model.TvShow

object TvShowMapper {
    fun fromDataToDomain(tvShowData: TvShow): com.alejofila.domain.model.TvShow {
        with(tvShowData) {
            return com.alejofila.domain.model.TvShow(
                name,
                rating,
                id,
                overview,
                coverImage
            )

        }
    }
}