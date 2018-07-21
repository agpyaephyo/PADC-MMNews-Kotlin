package com.padcmyanmar.mmnews.kotlin.network

import com.padcmyanmar.mmnews.kotlin.network.responses.GetNewsResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {

    @FormUrlEncoded
    @POST("v1/getMMNews.php")
    fun loadMMNews(
            @Field("page") pageIndex: Int,
            @Field("access_token") accessToken: String) : Observable<GetNewsResponse>
}