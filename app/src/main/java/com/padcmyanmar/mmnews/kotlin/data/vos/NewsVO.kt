package com.padcmyanmar.mmnews.kotlin.data.vos

open class NewsVO(newsId: String = "",
                  brief: String = "",
                  details: String = "",
                  images: List<String> = ArrayList(),
                  postedDate: String = "",
                  publication: PublicationVO? = null,
                  favoriteActions: List<FavoriteActionVO> = ArrayList(),
                  commentActions: List<CommentActionVO> = ArrayList(),
                  sentToActions: List<SentToActionVO> = ArrayList()) {

    open var newsId: String = newsId
        get() = "PADC-$field"
        set(value) {
            field = "PADC-$value"
        }

    var brief: String = brief
    var details: String = details
    var images: List<String> = images
    var postedDate: String = postedDate

    var publication: PublicationVO? = publication
    var favoriteActions: List<FavoriteActionVO> = favoriteActions

    var commentActions = commentActions
    var sentToActions = sentToActions
}