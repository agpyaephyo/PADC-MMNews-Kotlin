package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

class CommentActionVO {

    @SerializedName("comment-id")
    var commentId: String? = null

    @SerializedName("comment")
    var comment: String? = null

    @SerializedName("comment-date")
    var commentDate: String? = null

    @SerializedName("acted-user")
    var actedUser: ActedUserVO? = null
}