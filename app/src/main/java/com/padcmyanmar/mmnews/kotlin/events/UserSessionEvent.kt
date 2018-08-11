package com.padcmyanmar.mmnews.kotlin.events

import com.padcmyanmar.mmnews.kotlin.data.vos.LoginUserVO

class UserSessionEvent {

    class LoginUserSuccessEvent(val loginUser : LoginUserVO)
}