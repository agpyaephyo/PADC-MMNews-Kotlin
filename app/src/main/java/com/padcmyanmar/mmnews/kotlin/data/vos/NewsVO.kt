package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

open class NewsVO(newsId: String = "",
                  brief: String = "",
                  details: String = "",
                  images: List<String> = ArrayList(),
                  postedDate: String = "",
                  publication: PublicationVO? = null,
                  favoriteActions: List<FavoriteActionVO> = ArrayList(),
                  commentActions: List<CommentActionVO> = ArrayList(),
                  sentToActions: List<SentToActionVO> = ArrayList()) {

    @SerializedName("news-id")
    open var newsId: String = newsId
    /*
    get() = "PADC-$field"
    set(value) {
        field = "PADC-$value"
    }
    */

    @SerializedName("brief")
    var brief: String = brief

    @SerializedName("details")
    var details: String = details

    @SerializedName("images")
    var images: List<String>? = images
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("posted-date")
    var postedDate: String = postedDate

    @SerializedName("publication")
    var publication: PublicationVO? = publication

    @SerializedName("favorites")
    var favoriteActions: List<FavoriteActionVO>? = favoriteActions
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("comments")
    var commentActions : List<CommentActionVO>? = commentActions
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("sent-tos")
    var sentToActions : List<SentToActionVO>? = sentToActions
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }
}