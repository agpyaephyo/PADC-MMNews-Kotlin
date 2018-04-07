package com.padcmyanmar.mmnews.kotlin.data.vos

import com.google.gson.annotations.SerializedName

class ActedUserVO(@SerializedName("user-id") var userId: String = "",
                  @SerializedName("user-name") var userName: String = "",
                  @SerializedName("profile-image") var profileImage: String = "") {
}