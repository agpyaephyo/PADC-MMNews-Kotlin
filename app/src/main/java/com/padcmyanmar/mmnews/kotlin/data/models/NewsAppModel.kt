package com.padcmyanmar.mmnews.kotlin.data.models

import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import com.padcmyanmar.mmnews.kotlin.network.NewsDataAgent
import com.padcmyanmar.mmnews.kotlin.utils.AppConstants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class NewsAppModel private constructor() {
    companion object {
        private var INSTANCE: NewsAppModel? = null
        fun getInstance(): NewsAppModel {
            if (INSTANCE == null) {
                INSTANCE = NewsAppModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private var mNewsPage: Int
    private var mNewsData: HashMap<String, NewsVO>

    fun loadNews() {
        NewsDataAgent.getInstance().loadNews(AppConstants.ACCESS_TOKEN, mNewsPage)
    }

    fun forceLoadNews() {
        mNewsPage = 1
        NewsDataAgent.getInstance().loadNews(AppConstants.ACCESS_TOKEN, mNewsPage)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNewsLoadedEvent(newsLoadedEvent: DataEvent.NewsLoadedEvent) {
        for (news: NewsVO in newsLoadedEvent.loadedNews) {
            mNewsData[news.newsId] = news
        }
        mNewsPage = newsLoadedEvent.loadedPageIndex + 1
    }

    init {
        EventBus.getDefault().register(this)
        mNewsPage = 1
        mNewsData = HashMap()
    }
}