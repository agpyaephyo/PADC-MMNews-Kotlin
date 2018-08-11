package com.padcmyanmar.mmnews.kotlin.fragments

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.adapters.HighlightNewsAdapter
import com.padcmyanmar.mmnews.kotlin.data.models.NewsAppModel
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import kotlinx.android.synthetic.main.fragment_highlight_news.*
import kotlinx.android.synthetic.main.fragment_highlight_news.view.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HighlightNewsFragment : BaseFragment() {

    private lateinit var mAdapter: HighlightNewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_highlight_news, container, false)

        mAdapter = HighlightNewsAdapter()
        view.pagerHighlightNews.adapter = mAdapter

        view.pagerHighlightNews.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                piHighlightNews.setCurrentPage(position)
            }

        })

        mAdapter.setNewData(NewsAppModel.getInstance().getNews())
        view.piHighlightNews.setNumPage(mAdapter.count)

        return view
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNewsLoadedEvent(newsLoadedEvent: DataEvent.NewsLoadedEvent) {
        mAdapter.setNewData(newsLoadedEvent.loadedNews)
        view!!.piHighlightNews.setNumPage(mAdapter.count)
    }
}