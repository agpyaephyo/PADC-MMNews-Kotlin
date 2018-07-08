package com.padcmyanmar.mmnews.kotlin.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.mmnews.kotlin.data.vos.ActedUserVO

@Dao
interface ActedUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActedUser(actedUser: ActedUserVO): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActedUsers(actedUsers: List<ActedUserVO>): LongArray

    @Query("SELECT * FROM acted_users WHERE user_id = :userId")
    fun getActedUserById(userId: String): ActedUserVO
}