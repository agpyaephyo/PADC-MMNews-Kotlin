package com.padcmyanmar.mmnews.kotlin.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO
import java.util.ArrayList

class GetNewsResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("apiVersion")
    private val apiVersion: String? = null

    @SerializedName("page")
    private val pageNo: Int = 0

    @SerializedName("mmNews")
    private var newsList: List<NewsVO>? = null

    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    fun getApiVersion(): String? {
        return apiVersion
    }

    fun getPageNo(): Int {
        return pageNo
    }

    fun getNewsList(): List<NewsVO> {
        if (newsList == null) {
            newsList = ArrayList<NewsVO>()
        }
        val newsListVal = newsList
        return newsListVal!!
    }
}