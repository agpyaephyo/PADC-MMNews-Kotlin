package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

class SentToActionVO {

    @SerializedName("send-to-id")
    var sendToId: String? = null

    @SerializedName("sent-date")
    var sentDate: String? = null

    @SerializedName("acted-user")
    var sender: ActedUserVO? = null

    @SerializedName("received-user")
    var receiver: ActedUserVO? = null
}