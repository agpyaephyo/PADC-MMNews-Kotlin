package com.padcmyanmar.mmnews.kotlin.data.models

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.padcmyanmar.mmnews.kotlin.network.NewsApi
import com.padcmyanmar.mmnews.kotlin.persistence.NewsDB
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel protected constructor(context: Context) {

    protected var mTheApi: NewsApi
    protected var mTheDB: NewsDB

    init {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        mTheApi = retrofit.create<NewsApi>(NewsApi::class.java!!)
        mTheDB = NewsDB.getDatabase(context)
    }
}