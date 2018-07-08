package com.padcmyanmar.mmnews.kotlin.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.padcmyanmar.mmnews.kotlin.data.vos.*
import com.padcmyanmar.mmnews.kotlin.persistence.dao.*

@Database(entities = arrayOf(ActedUserVO::class, FavoriteActionVO::class, CommentActionVO::class, SentToActionVO::class, PublicationVO::class, NewsVO::class), version = 1, exportSchema = false)
abstract class NewsDB : RoomDatabase() {

    abstract fun actedUserDao(): ActedUserDao
    abstract fun favoriteActionDao(): FavoriteActionDao
    abstract fun commentActionDao(): CommentActionDao
    abstract fun sentToActionDao(): SentToActionDao
    abstract fun publicationDao(): PublicationDao
    abstract fun newsDao(): NewsDao

    companion object {

        private val DB_NAME = "SFC-News.DB"
        private lateinit var INSTANCE: NewsDB

        fun getDatabase(context: Context): NewsDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, NewsDB::class.java, DB_NAME)
                        .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                        .build()
            }
            return INSTANCE
        }
    }
}