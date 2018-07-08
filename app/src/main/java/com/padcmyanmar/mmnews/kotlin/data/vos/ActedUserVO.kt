package com.padcmyanmar.mmnews.kotlin.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "acted_users")
class ActedUserVO {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @SerializedName("user-id")
    @ColumnInfo(name = "user_id")
    var userId: String? = null

    @SerializedName("user-name")
    @ColumnInfo(name = "user_name")
    var userName: String? = null

    @SerializedName("profile-image")
    @ColumnInfo(name = "profile_image")
    var profileImage: String? = null
}