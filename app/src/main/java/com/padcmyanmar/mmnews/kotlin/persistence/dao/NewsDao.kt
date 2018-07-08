package com.padcmyanmar.mmnews.kotlin.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO

@Dao
interface NewsDao {

    @get:Query("SELECT * FROM news")
    val allNews: List<NewsVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(newsVO: List<NewsVO>): LongArray

    @Query("SELECT * FROM news WHERE news_id = :newsId")
    fun getNewsById(newsId: String): NewsVO

    @Query("SELECT * FROM news WHERE news_id = :newsId")
    fun getNewsByIdLD(newsId: String): LiveData<NewsVO>
}