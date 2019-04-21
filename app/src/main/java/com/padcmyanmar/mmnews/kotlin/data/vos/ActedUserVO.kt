package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

data class ActedUserVO(
        @SerializedName("user-id") val userId: String,
        @SerializedName("user-name") val userName: String,
        @SerializedName("profile-image") val profileImage: String)