package com.padcmyanmar.mmnews.kotlin.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.padcmyanmar.mmnews.kotlin.data.vos.*
import com.padcmyanmar.mmnews.kotlin.persistence.dao.*

@Database(entities = [(NewsVO::class)],
        version = 2, exportSchema = false)
abstract class NewsDB : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {

        private val DB_NAME = "SFC-News.DB"
        private var INSTANCE: NewsDB? = null

        fun getDatabase(context: Context): NewsDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, NewsDB::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                        .build()
            }
            val i = INSTANCE
            return i!!
        }
    }
}