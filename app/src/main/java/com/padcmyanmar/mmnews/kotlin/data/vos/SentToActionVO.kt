package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

class SentToActionVO {

    @SerializedName("send-to-id")
    val sentToId: String = ""

    @SerializedName("sent-date")
    val sentDate: String = ""

    @SerializedName("acted-user")
    val sender: ActedUserVO? = null

    @SerializedName("received-user")
    val receiver: ActedUserVO? = null
}