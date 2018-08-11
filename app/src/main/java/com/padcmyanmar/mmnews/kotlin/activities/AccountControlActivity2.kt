package com.padcmyanmar.mmnews.kotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.adapters.AccountControlAdapter
import com.padcmyanmar.mmnews.kotlin.delegates.LoginDelegate
import com.padcmyanmar.mmnews.kotlin.fragments.LoginFragment
import com.padcmyanmar.mmnews.kotlin.fragments.RegisterFragment
import kotlinx.android.synthetic.main.activity_account_control_2.*

class AccountControlActivity2 : BaseActivity(), LoginDelegate {
    override fun onTapLogin(phoneNo: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapRegisterNewAccount() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccesssLoginUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var mAdapter: AccountControlAdapter

    companion object {
        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, AccountControlActivity2::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_control_2)

        mAdapter = AccountControlAdapter(supportFragmentManager)
        mAdapter.addTab(LoginFragment(), "Login")
        mAdapter.addTab(RegisterFragment(), "Register")
        pagerAccountControl.adapter = mAdapter
        tlAccountControl.setupWithViewPager(pagerAccountControl)
    }
}