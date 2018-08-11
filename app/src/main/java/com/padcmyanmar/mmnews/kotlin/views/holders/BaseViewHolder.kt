package com.padcmyanmar.mmnews.kotlin.views.holders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<W : Any>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    protected lateinit var mData: W

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun setData(data: W)
}