package com.padcmyanmar.mmnews.kotlin.views.items

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO

class HighlightNewsViewItem : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindData(news : NewsVO) {
        //bind logic
    }
}