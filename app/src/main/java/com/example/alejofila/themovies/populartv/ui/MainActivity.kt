package com.example.alejofila.themovies.populartv.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.alejofila.newsdemo.common.uimodel.TvShowUiModel
import com.example.alejofila.themovies.R
import com.example.alejofila.themovies.populartv.adapter.TvShowsAdapter
import com.example.alejofila.themovies.populartv.presenter.PopularTvShowsPresenter
import com.example.alejofila.themovies.populartv.viewcontract.PopularTvShowsView
import com.example.alejofila.themovies.populartv.viewutils.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), PopularTvShowsView {



    private lateinit var scrollListener: EndlessRecyclerViewScrollListener
    private lateinit var adapter: TvShowsAdapter

    private val presenter: PopularTvShowsPresenter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = TvShowsAdapter()
        recycler.adapter = adapter
        presenter.view = this
        val layoutManager = GridLayoutManager(this, 2)
        recycler.layoutManager = layoutManager
        scrollListener = object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                presenter.queryPopularTvShows()
            }
        }
        recycler.addOnScrollListener(scrollListener)
        presenter.queryPopularTvShows()


    }
    override fun showNextPageOfShows(shows: List<TvShowUiModel>) {
        adapter.appendData(shows)
    }

    override fun showNoMoreShowsMessage() {
        Toast.makeText(this,R.string.no_more_shows,Toast.LENGTH_SHORT)
            .show()
    }
    override fun showServerError() {
        Toast.makeText(this,R.string.server_error,Toast.LENGTH_SHORT)
            .show()
    }
    override fun showEmptyView() {
        empty_view.visibility = View.VISIBLE
        recycler.visibility = View.GONE

    }
}
