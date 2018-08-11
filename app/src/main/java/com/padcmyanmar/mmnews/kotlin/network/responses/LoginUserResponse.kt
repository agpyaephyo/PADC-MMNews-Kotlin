package com.padcmyanmar.mmnews.kotlin.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mmnews.kotlin.data.vos.LoginUserVO

class LoginUserResponse(@SerializedName("code") val code: Int,
                        @SerializedName("message") val message: String,
                        @SerializedName("login_user") val loginUser: LoginUserVO?)