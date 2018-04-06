package com.padcmyanmar.mmnews.kotlin.data.vos

class SportNewsVO(newsId: String = "",
                  brief: String = "",
                  details: String = "",
                  images: List<String> = ArrayList(),
                  postedDate: String = "",
                  publication: PublicationVO? = null,
                  favoriteActions: List<FavoriteActionVO> = ArrayList(),
                  commentActions: List<CommentActionVO> = ArrayList(),
                  sentToActions: List<SentToActionVO> = ArrayList(),
                  sportType: String = "") : NewsVO(newsId, brief, details, images, postedDate, publication, favoriteActions, commentActions, sentToActions) {

    var sportType: String = sportType
    override var newsId: String = newsId
        get() = "Sport-$field"
        set(value) {
            field = "Sport-$value"
        }
}