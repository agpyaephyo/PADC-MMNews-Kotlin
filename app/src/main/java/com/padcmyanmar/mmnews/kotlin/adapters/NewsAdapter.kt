package com.padcmyanmar.mmnews.kotlin.adapters

import android.content.Context
import android.view.ViewGroup
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO
import com.padcmyanmar.mmnews.kotlin.views.holders.NewsViewHolder
import com.padcmyanmar.mmnews.kotlin.delegates.NewsItemDelegate

class NewsAdapter(context: Context,
                  private val mNewsItemDelegate: NewsItemDelegate) : BaseRecyclerAdapter<NewsViewHolder, NewsVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val newsItemView = mLayoutInflator.inflate(R.layout.view_item_news, parent, false)
        return NewsViewHolder(newsItemView, mNewsItemDelegate)
    }

    override fun getItemCount(): Int {
        return 24
    }
}