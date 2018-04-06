package com.padcmyanmar.mmnews.kotlin.data.vos

class NewsVO(newsId: String = "",
             brief: String = "",
             details: String = "",
             images: List<String> = ArrayList(),
             postedDate: String = "") {

    var newsId: String = newsId
        get() = "PADC-$field"
        set(value) {
            field = "PADC-$value"
        }

    var brief: String = brief
    var details: String = details
    var images: List<String> = images
    var postedDate: String = postedDate

}