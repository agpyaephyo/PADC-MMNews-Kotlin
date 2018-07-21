package com.padcmyanmar.mmnews.kotlin.data.models

import android.content.Context
import android.util.Log
import com.padcmyanmar.mmnews.kotlin.MMNewsApp
import com.padcmyanmar.mmnews.kotlin.data.vos.*
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import com.padcmyanmar.mmnews.kotlin.network.NewsDataAgent
import com.padcmyanmar.mmnews.kotlin.network.responses.GetNewsResponse
import com.padcmyanmar.mmnews.kotlin.utils.AppConstants
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.ArrayList

class NewsAppModel private constructor(context : Context) : BaseModel(context) {
    companion object {
        private var INSTANCE: NewsAppModel? = null
        fun getInstance(): NewsAppModel {
            if (INSTANCE == null) {
                throw RuntimeException("NewsModel is being invoked before initializing.")
            }

            val i = INSTANCE
            return i!!
        }

        fun initNewsAppModel(context : Context) {
            INSTANCE = NewsAppModel(context)
        }
    }

    private var mNewsPage: Int

    init {
        EventBus.getDefault().register(this)
        mNewsPage = 1
    }

    fun loadNews() {
        //NewsDataAgent.getInstance().loadNews(AppConstants.ACCESS_TOKEN, mNewsPage)

        mTheApi.loadMMNews(mNewsPage, AppConstants.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetNewsResponse> {
                    override fun onNext(newsResponse: GetNewsResponse) {
                        if (newsResponse.getNewsList().isNotEmpty()) {

                            persistNewsList(newsResponse.getNewsList())
                            mNewsPage = newsResponse.getPageNo() + 1

                            //newsListLD.setValue(newsResponse!!.getNewsList())
                        } else {
                            //errorPS.setValue("No data could be loaded for now. Pls try again later.")
                        }
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        //errorPS.setValue(e.message)
                    }

                    override fun onComplete() {

                    }
                })
    }

    fun forceLoadNews() {
        mNewsPage = 1
        NewsDataAgent.getInstance().loadNews(AppConstants.ACCESS_TOKEN, mNewsPage)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNewsLoadedEvent(newsLoadedEvent: DataEvent.NewsLoadedEvent) {
        persistNewsList(newsLoadedEvent.loadedNews)
        mNewsPage = newsLoadedEvent.loadedPageIndex + 1
    }

    private fun persistNewsList(newsList: List<NewsVO>) {
        val insertedNews = mTheDB.newsDao().insertNews(newsList)
        Log.d(MMNewsApp.TAG, "insertedNews : ${insertedNews.size}")
    }
}