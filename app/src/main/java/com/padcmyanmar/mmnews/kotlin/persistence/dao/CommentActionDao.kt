package com.padcmyanmar.mmnews.kotlin.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.mmnews.kotlin.data.vos.CommentActionVO

@Dao
interface CommentActionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCommentActions(commentActionVOS: List<CommentActionVO>): LongArray

    @Query("SELECT * FROM comments WHERE news_id = :newsId")
    fun getCommentActionsByNewsId(newsId: String): List<CommentActionVO>
}