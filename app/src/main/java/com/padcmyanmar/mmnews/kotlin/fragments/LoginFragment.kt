package com.padcmyanmar.mmnews.kotlin.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.activities.HomeActivity
import com.padcmyanmar.mmnews.kotlin.delegates.LoginDelegate
import com.padcmyanmar.mmnews.kotlin.events.UserSessionEvent
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class LoginFragment : BaseFragment() {

    lateinit var mDelegate: LoginDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mDelegate = context as LoginDelegate
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val loginView = inflater.inflate(R.layout.fragment_login, container, false)

        loginView.btnRegisterNewAccount.setOnClickListener {
            //Snackbar.make(it, "Tap Register New Account", Snackbar.LENGTH_INDEFINITE).show()
            mDelegate.onTapRegisterNewAccount()
        }

        loginView.btnLogin.setOnClickListener {
            val phoneNo = etUserPhone.text.toString()
            val password = etUserPassword.text.toString()
            mDelegate.onTapLogin(phoneNo, password)
        }

        return loginView
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessLoginUser(event: UserSessionEvent.LoginUserSuccessEvent) {
        mDelegate.onSuccesssLoginUser()
    }
}