package com.padcmyanmar.mmnews.kotlin.adapters

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO
import com.padcmyanmar.mmnews.kotlin.views.items.HighlightNewsViewItem

class HighlightNewsAdapter : PagerAdapter() {

    private var mData : List<NewsVO> = ArrayList()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object` as HighlightNewsViewItem)
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflator = LayoutInflater.from(container.context)
        val viHighlightNews = inflator.inflate(R.layout.view_item_highlight_news, container, false)
                as HighlightNewsViewItem

        viHighlightNews.bindData(mData[position])
        container.addView(viHighlightNews)
        return viHighlightNews
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as HighlightNewsViewItem)
    }

    fun setNewData(newsList : List<NewsVO>) {
        mData = newsList
        notifyDataSetChanged()
    }
}