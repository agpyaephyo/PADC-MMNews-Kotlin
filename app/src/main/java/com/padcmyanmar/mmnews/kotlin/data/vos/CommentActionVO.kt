package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

data class CommentActionVO(
        @SerializedName("comment-id") val commentId: String,
        @SerializedName("comment") val comment: String,
        @SerializedName("comment-date") val commentDate: String,
        @SerializedName("acted-user") val actedUser: ActedUserVO)