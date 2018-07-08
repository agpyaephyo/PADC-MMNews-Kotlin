package com.padcmyanmar.mmnews.kotlin.data.models

import android.content.Context
import android.util.Log
import com.padcmyanmar.mmnews.kotlin.MMNewsApp
import com.padcmyanmar.mmnews.kotlin.data.vos.*
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import com.padcmyanmar.mmnews.kotlin.network.NewsDataAgent
import com.padcmyanmar.mmnews.kotlin.utils.AppConstants
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
        NewsDataAgent.getInstance().loadNews(AppConstants.ACCESS_TOKEN, mNewsPage)
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
        //Prepare data to insert
        val publicationList = ArrayList<PublicationVO>()
        val favoriteActionList = ArrayList<FavoriteActionVO>()
        val commentActionList = ArrayList<CommentActionVO>()
        val sentToList = ArrayList<SentToActionVO>()
        val actedUserList = ArrayList<ActedUserVO>()

        for (news in newsList) {
            publicationList.add(news.publication!!)
            for (favoriteAction in news.favoriteActions!!) {
                favoriteAction.newsId = news.newsId

                favoriteActionList.add(favoriteAction)
                actedUserList.add(favoriteAction.actedUser!!)
            }
            for (commentAction in news.commentActions!!) {
                commentAction.newsId = news.newsId

                commentActionList.add(commentAction)
                actedUserList.add(commentAction.actedUser!!)
            }
            for (sentTo in news.sentToActions!!) {
                sentTo.newsId = news.newsId

                sentToList.add(sentTo)
                actedUserList.add(sentTo.sender!!)
                actedUserList.add(sentTo.receiver!!)
            }
        }

        //Actual Inserts - with sequence
        val insertedUsers = mTheDB.actedUserDao().insertActedUsers(actedUserList)
        Log.d(MMNewsApp.TAG, "insertedUsers : $insertedUsers")

        val insertedSentTos = mTheDB.sentToActionDao().insertSentToActions(sentToList)
        Log.d(MMNewsApp.TAG, "insertedSentTos : $insertedSentTos")

        val insertedComments = mTheDB.commentActionDao().insertCommentActions(commentActionList)
        Log.d(MMNewsApp.TAG, "insertedComments : $insertedComments")

        val insertedFavorites = mTheDB.favoriteActionDao().insertFavoriteActions(favoriteActionList)
        Log.d(MMNewsApp.TAG, "insertedFavorites : $insertedFavorites")

        val insertedPublications = mTheDB.publicationDao().insertPublications(publicationList)
        Log.d(MMNewsApp.TAG, "insertedPublications : $insertedPublications")

        val insertedNews = mTheDB.newsDao().insertNews(newsList)
        Log.d(MMNewsApp.TAG, "insertedNews : $insertedNews")
    }
}