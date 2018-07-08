package com.padcmyanmar.mmnews.kotlin.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.text.TextUtils
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favorites")
class FavoriteActionVO {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @SerializedName("favorite-id")
    @ColumnInfo(name = "favorite_id")
    var favoriteId: String? = null

    @SerializedName("favorite-date")
    @ColumnInfo(name = "favorite_date")
    var favoriteDate: String? = null

    @SerializedName("acted-user")
    @Ignore
    var actedUser: ActedUserVO? = null

    @ColumnInfo(name = "acted_user_id")
    @Transient
    var actedUserId: String? = null
        get() {
            if (TextUtils.isEmpty(field)) {
                this.actedUserId = actedUser!!.userId
            }
            return field
        }

    @ColumnInfo(name = "news_id")
    @Transient
    var newsId: String? = null
}