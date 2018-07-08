package com.padcmyanmar.mmnews.kotlin.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.mmnews.kotlin.data.vos.FavoriteActionVO

@Dao
interface FavoriteActionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteActions(favoriteActionVOS: List<FavoriteActionVO>): LongArray

    @Query("SELECT * FROM favorites WHERE news_id = :newsId")
    fun getFavoriteActionsByNewsId(newsId: String): List<FavoriteActionVO>
}