package com.padcmyanmar.mmnews.kotlin.data.models

import com.padcmyanmar.mmnews.kotlin.data.vos.LoginUserVO
import com.padcmyanmar.mmnews.kotlin.events.UserSessionEvent
import com.padcmyanmar.mmnews.kotlin.network.NewsDataAgent
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class LoginUserModel : BaseModel() {

    companion object {
        private var INSTANCE: LoginUserModel? = null
        fun getInstance(): LoginUserModel {
            if (INSTANCE == null) {
                INSTANCE = LoginUserModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private var mLoginUser: LoginUserVO? = null

    fun isUserLogin(): Boolean {
        return mLoginUser != null
    }

    fun loginUser(phoneNo: String, password: String) {
        NewsDataAgent.getInstance().loginUser(phoneNo, password)
    }

    fun getLoginUser() : LoginUserVO? {
        return mLoginUser
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSuccessLoginUser(loginUserSuccessEvent: UserSessionEvent.LoginUserSuccessEvent) {
        mLoginUser = loginUserSuccessEvent.loginUser
    }
}