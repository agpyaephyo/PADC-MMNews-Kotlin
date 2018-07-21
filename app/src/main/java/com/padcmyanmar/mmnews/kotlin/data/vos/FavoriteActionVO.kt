package com.padcmyanmar.mmnews.kotlin.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.text.TextUtils
import com.google.gson.annotations.SerializedName

class FavoriteActionVO {

    @SerializedName("favorite-id")
    var favoriteId: String? = null

    @SerializedName("favorite-date")
    var favoriteDate: String? = null

    @SerializedName("acted-user")
    var actedUser: ActedUserVO? = null
}