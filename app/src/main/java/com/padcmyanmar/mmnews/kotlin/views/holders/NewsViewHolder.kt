package com.padcmyanmar.mmnews.kotlin.views.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO
import com.padcmyanmar.mmnews.kotlin.delegates.NewsItemDelegate
import kotlinx.android.synthetic.main.view_item_news.view.*

class NewsViewHolder(itemView: View,
                     private val mDelegate: NewsItemDelegate) : BaseViewHolder<NewsVO>(itemView) {

    override fun setData(data: NewsVO) {
        mData = data
        if (data.publication != null) {
            Glide.with(itemView.context)
                    .load(data.publication!!.logo)
                    .into(itemView.ivPublicationLogo)
            itemView.tvPublicationName!!.text = data.publication!!.title
        }

        itemView.tvPublishedDate!!.text = data.postedDate

        itemView.tvBriefNews.text = data.brief
        if (!data.images!!.isEmpty()) {
            itemView.ivNewsHeroImage!!.visibility = View.VISIBLE
            Glide.with(itemView.context)
                    .load(data.images!![0])
                    .into(itemView.ivNewsHeroImage)
        } else {
            itemView.ivNewsHeroImage!!.visibility = View.GONE
        }

        val statisticalData = itemView.context.getString(R.string.format_news_statistical_data,
                data.favoriteActions!!.size,
                data.commentActions!!.size,
                data.sentToActions!!.size)
        itemView.tvNewsStatisticalData!!.text = statisticalData
    }

    override fun onClick(v: View) {
        mDelegate.onTapNews(mData)
    }
}