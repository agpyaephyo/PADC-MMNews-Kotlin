package com.padcmyanmar.mmnews.kotlin.network

import com.padcmyanmar.mmnews.kotlin.network.responses.GetNewsResponse
import com.padcmyanmar.mmnews.kotlin.network.responses.LoginUserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {

    companion object {
        //APIs
        private const val API_LOAD_NEWS = "v1/getMMNews.php"
        private const val API_USER_LOGIN = "v1/login.php"

        //Params for APIs
        private const val PARAM_PAGE = "page"
        private const val PARAM_ACCESS_TOKEN = "access_token"
        private const val PARAM_PHONE_NO = "phoneNo"
        private const val PARAM_PASSWORD= "password"

        //Response Code
        const val RC_SUCCESS = 200
    }

    @FormUrlEncoded
    @POST(API_LOAD_NEWS)
    fun loadMMNews(
            @Field(PARAM_PAGE) pageIndex: Int,
            @Field(PARAM_ACCESS_TOKEN) accessToken: String) : Call<GetNewsResponse>

    @FormUrlEncoded
    @POST(API_USER_LOGIN)
    fun loginUser(@Field(PARAM_PHONE_NO) phoneNo : String,
                  @Field(PARAM_PASSWORD) password : String) : Call<LoginUserResponse>
}