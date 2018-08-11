package com.padcmyanmar.mmnews.kotlin.network

import com.google.gson.Gson
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import com.padcmyanmar.mmnews.kotlin.events.ErrorEvent
import com.padcmyanmar.mmnews.kotlin.events.UserSessionEvent
import com.padcmyanmar.mmnews.kotlin.network.responses.GetNewsResponse
import com.padcmyanmar.mmnews.kotlin.network.responses.LoginUserResponse
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NewsDataAgent {

    companion object {
        private var INSTANCE: NewsDataAgent? = null
        fun getInstance(): NewsDataAgent {
            if (INSTANCE == null) {
                INSTANCE = NewsDataAgent()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private val mNewsApi: NewsApi

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mNewsApi = retrofit.create(NewsApi::class.java)
    }

    fun loadNews(accessToken: String, page: Int) {
        val newsResponseCall = mNewsApi.loadMMNews(page, accessToken)
        newsResponseCall.enqueue(object : Callback<GetNewsResponse> {
            override fun onFailure(call: Call<GetNewsResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetNewsResponse>, response: Response<GetNewsResponse>) {
                val newsResponse: GetNewsResponse? = response.body()
                if (newsResponse != null
                        && newsResponse.getCode() == NewsApi.RC_SUCCESS
                        && newsResponse.getNewsList().isNotEmpty()) {
                    val newsLoadedEvent = DataEvent.NewsLoadedEvent(newsResponse.getPageNo(), newsResponse.getNewsList())
                    EventBus.getDefault().post(newsLoadedEvent)
                } else {
                    if (newsResponse != null)
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(newsResponse.getMessage()))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                }
            }
        })
    }

    fun loginUser(phoneNo: String, password: String) {
        val loginUserCall = mNewsApi.loginUser(phoneNo, password)
        loginUserCall.enqueue(object : Callback<LoginUserResponse> {
            override fun onFailure(call: Call<LoginUserResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<LoginUserResponse>, response: Response<LoginUserResponse>) {
                val loginUserResponse: LoginUserResponse? = response.body()
                if (loginUserResponse != null
                        && loginUserResponse.code == NewsApi.RC_SUCCESS
                        && loginUserResponse.loginUser != null) {
                    val loginUserSuccessEvent = UserSessionEvent.LoginUserSuccessEvent(loginUserResponse.loginUser)
                    EventBus.getDefault().post(loginUserSuccessEvent)
                } else {
                    if(loginUserResponse != null) {
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(loginUserResponse.message))
                    } else {
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                    }
                }
            }
        })
    }
}