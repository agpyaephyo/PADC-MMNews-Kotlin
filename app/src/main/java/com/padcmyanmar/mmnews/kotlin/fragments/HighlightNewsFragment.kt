package com.padcmyanmar.mmnews.kotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.adapters.HighlightNewsAdapter
import kotlinx.android.synthetic.main.fragment_highlight_news.view.*

class HighlightNewsFragment : BaseFragment() {

    private lateinit var mAdapter: HighlightNewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_highlight_news, container, false)

        mAdapter = HighlightNewsAdapter()
        view.pagerHighlightNews.adapter = mAdapter

        return view
    }
}