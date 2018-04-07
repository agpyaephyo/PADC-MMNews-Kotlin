package com.padcmyanmar.mmnews.kotlin.events

import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO

class DataEvent {

    class NewsLoadedEvent(val loadedPageIndex: Int, val loadedNews: List<NewsVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")
}