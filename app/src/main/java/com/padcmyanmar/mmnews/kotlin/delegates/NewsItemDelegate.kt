package com.padcmyanmar.mmnews.kotlin.delegates

import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO

interface NewsItemDelegate {
    fun onTapComment(news: NewsVO)
    fun onTapSendTo(news: NewsVO)
    fun onTapFavorite(news: NewsVO)
    fun onTapStatistics(news: NewsVO)
    fun onTapNews(news: NewsVO)
}