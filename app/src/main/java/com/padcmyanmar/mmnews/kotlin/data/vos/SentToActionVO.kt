package com.padcmyanmar.mmnews.kotlin.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.text.TextUtils
import com.google.gson.annotations.SerializedName

@Entity(tableName = "sent_tos")
class SentToActionVO {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @SerializedName("send-to-id")
    @ColumnInfo(name = "sent_to_id")
    var sendToId: String? = null

    @SerializedName("sent-date")
    @ColumnInfo(name = "sent_date")
    var sentDate: String? = null

    @SerializedName("acted-user")
    @Ignore
    var sender: ActedUserVO? = null

    @SerializedName("received-user")
    @Ignore
    var receiver: ActedUserVO? = null

    @ColumnInfo(name = "sender_id")
    @Transient
    var senderId: String? = null
        get() {
            if (TextUtils.isEmpty(field)) {
                this.senderId = sender!!.userId
            }
            return field
        }

    @ColumnInfo(name = "receiver_id")
    @Transient
    var receiverId: String? = null
        get() {
            if (TextUtils.isEmpty(field)) {
                this.receiverId = receiver!!.userId
            }
            return field
        }

    @ColumnInfo(name = "news_id")
    @Transient
    var newsId: String? = null
}