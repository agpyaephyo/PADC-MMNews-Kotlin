package com.padcmyanmar.mmnews.kotlin.activities

import android.os.Bundle
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.data.models.LoginUserModel
import com.padcmyanmar.mmnews.kotlin.delegates.LoginDelegate
import com.padcmyanmar.mmnews.kotlin.fragments.LoginFragment
import com.padcmyanmar.mmnews.kotlin.fragments.RegisterFragment

class AccountControlActivity : BaseActivity(), LoginDelegate {
    override fun onSuccesssLoginUser() {
        /*
        val homeIntent = Intent(context, HomeActivity::class.java)
        startActivity(homeIntent)
        */
        onBackPressed()
    }

    override fun onTapLogin(phoneNo : String, password : String) {
        LoginUserModel.getInstance().loginUser(phoneNo, password)
    }

    override fun onTapRegisterNewAccount() {
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.flContainer, RegisterFragment())
                .addToBackStack("navigate-to-register")
                .commit()
    }

    companion object {
        const val ACTION_TYPE = "action_type"
        const val ACTION_TYPE_LOGIN = 1111
        const val ACTION_TYPE_REGISTER = 2222
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_control)

        val actionType = intent.extras.getInt(ACTION_TYPE)
        if (actionType == ACTION_TYPE_LOGIN) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.flContainer, LoginFragment())
                    .commit()
        } else if (actionType == ACTION_TYPE_REGISTER) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.flContainer, RegisterFragment())
                    .commit()
        }
    }
}