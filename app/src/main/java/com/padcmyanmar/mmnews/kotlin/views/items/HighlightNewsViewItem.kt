package com.padcmyanmar.mmnews.kotlin.views.items

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO
import kotlinx.android.synthetic.main.view_item_highlight_news.view.*

class HighlightNewsViewItem : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindData(news: NewsVO) {
        //bind logic
        tvNewsHeadLine.text = news.brief
        if (news.images != null && !news.images!!.isEmpty()) {
            Glide.with(context)
                    .load(news.images!![0])
                    .into(ivNewsBg)
        } else {
            Glide.with(context)
                    .load(news.publication!!.logo)
                    .into(ivNewsBg)
        }
    }
}