package com.example.alejofila.themovies.populartv.adapter

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v7.graphics.Palette
import android.support.v7.widget.RecyclerView
import android.view.View
import com.alejofila.newsdemo.common.uimodel.TvShowUiModel
import com.example.alejofila.data.network.TvShowService
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.tv_show_item.view.*

class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(tvShow: TvShowUiModel) {
        itemView.run {
            item_poster_title.text = tvShow.name
            item_poster_rating.text = tvShow.rating.toString()
            tvShow.image?.let {
                Picasso.with(this.context)
                    .load(TvShowService.getPosterPath(tvShow.image))
                    .into(object : Target {
                        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                        }

                        override fun onBitmapFailed(errorDrawable: Drawable?) {
                        }

                        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                            item_poster_post.setImageBitmap(bitmap)
                            Palette.from(bitmap)
                                .generate { palette ->
                                    val textWatch = palette.vibrantSwatch
                                    textWatch?.let {
                                        item_poster_palette.setBackgroundColor(textWatch.rgb)
                                        item_poster_rating.setTextColor(textWatch.bodyTextColor)
                                        item_poster_title.setTextColor(textWatch.titleTextColor)
                                    }

                                }
                        }
                    })
            }


        }
    }
    fun clear(){
        itemView.item_poster_post.setImageDrawable(null)
    }

}