package com.padcmyanmar.mmnews.kotlin

import android.app.Application
import com.padcmyanmar.mmnews.kotlin.data.models.NewsAppModel

class MMNewsApp : Application() {

    companion object {
        const val TAG = "MMNewsApp"
    }

    override fun onCreate() {
        super.onCreate()
        //NewsAppModel.getInstance()
    }
}