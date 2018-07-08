package com.padcmyanmar.mmnews.kotlin.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.text.TextUtils
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comments")
class CommentActionVO {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @SerializedName("comment-id")
    @ColumnInfo(name = "comment_id")
    var commentId: String? = null

    @SerializedName("comment")
    @ColumnInfo(name = "comment")
    var comment: String? = null

    @SerializedName("comment-date")
    @ColumnInfo(name = "comment_date")
    var commentDate: String? = null

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