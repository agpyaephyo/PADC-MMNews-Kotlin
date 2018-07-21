package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

class ActedUserVO {

    @SerializedName("user-id")
    var userId: String? = null

    @SerializedName("user-name")
    var userName: String? = null

    @SerializedName("profile-image")
    var profileImage: String? = null
}