package com.padcmyanmar.mmnews.kotlin.adapters

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.views.items.NewsDetailsImageViewItem

class NewsDetailsImagesAdapter : PagerAdapter() {

    private var mData: List<String> = ArrayList()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object` as NewsDetailsImageViewItem)
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflator = LayoutInflater.from(container.context)
        val viNewsDetailsImage = inflator.inflate(R.layout.view_item_news_details_image, container, false)
                as NewsDetailsImageViewItem

        viNewsDetailsImage.setData(mData[position])
        container.addView(viNewsDetailsImage)
        return viNewsDetailsImage
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as NewsDetailsImageViewItem)
    }

    fun setNewData(newsDetailsImages: List<String>?) {
        if (newsDetailsImages != null) {
            mData = newsDetailsImages
            notifyDataSetChanged()
        }
    }
}