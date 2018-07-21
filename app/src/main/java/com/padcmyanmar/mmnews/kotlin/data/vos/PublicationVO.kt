package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

class PublicationVO {

    @SerializedName("publication-id")
    var publicationId: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("logo")
    var logo: String? = null
}