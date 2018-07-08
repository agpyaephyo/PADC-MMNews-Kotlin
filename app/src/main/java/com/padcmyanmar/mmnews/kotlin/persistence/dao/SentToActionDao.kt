package com.padcmyanmar.mmnews.kotlin.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.mmnews.kotlin.data.vos.SentToActionVO

@Dao
interface SentToActionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSentToActions(sentToVOS: List<SentToActionVO>): LongArray

    @Query("SELECT * FROM sent_tos WHERE news_id = :newsId")
    fun getSentTosByNewsId(newsId: String): List<SentToActionVO>
}