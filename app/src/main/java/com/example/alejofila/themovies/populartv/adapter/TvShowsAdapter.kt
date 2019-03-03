package com.example.alejofila.themovies.populartv.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alejofila.newsdemo.common.uimodel.TvShowUiModel
import com.example.alejofila.themovies.R

class TvShowsAdapter : RecyclerView.Adapter<TvShowViewHolder>() {

    private  var tvShows = mutableListOf<TvShowUiModel>()
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.tv_show_item,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder?, position: Int) {
        holder?.bind(tvShows[position])
    }

    fun appendData(moreShows: List<TvShowUiModel>?) {
        val currentSize = tvShows.size
        tvShows.addAll(moreShows!!)
        val countSize = moreShows.size
        notifyItemRangeInserted(currentSize, countSize)
    }


}