package com.padcmyanmar.mmnews.kotlin.delegates

import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO

interface NewsItemDelegate {
    fun onTapComment()
    fun onTapSendTo()
    fun onTapFavorite()
    fun onTapStatistics()
    fun onTapNews(news: NewsVO)
}