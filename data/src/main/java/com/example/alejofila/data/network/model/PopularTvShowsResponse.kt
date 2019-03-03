package com.example.alejofila.data.network.model

import com.google.gson.annotations.SerializedName

data class PopularTvShowsResponse(
    val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    val results: List<TvShow>
)
data class TvShow(val name: String,
                  val rating: Double,
                  val id: Int,
                  val overview: String,
                  @SerializedName("poster_path")
                  val coverImage: String)

