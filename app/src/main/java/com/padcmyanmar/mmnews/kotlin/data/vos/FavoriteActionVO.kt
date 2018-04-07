package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

class FavoriteActionVO {

    @SerializedName("favorite-id")
    val favoriteId: String = ""

    @SerializedName("favorite-date")
    val favoriteDate: String = ""

    @SerializedName("acted-user")
    val actedUser: ActedUserVO? = null
}