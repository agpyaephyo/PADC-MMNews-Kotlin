package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

class PublicationVO(@SerializedName("publication-id") var publicationId: String = "",
                    @SerializedName("title") var title: String = "",
                    @SerializedName("logo") var logo: String = "")