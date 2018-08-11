package com.padcmyanmar.mmnews.kotlin.delegates

interface LoginDelegate {
    fun onTapLogin(phoneNo : String, password : String)
    fun onTapRegisterNewAccount()
    fun onSuccesssLoginUser()
}