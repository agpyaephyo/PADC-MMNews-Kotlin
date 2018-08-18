package com.padcmyanmar.mmnews.kotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.adapters.AccountControlAdapter
import com.padcmyanmar.mmnews.kotlin.delegates.LoginDelegate
import com.padcmyanmar.mmnews.kotlin.fragments.HighlightNewsFragment
import com.padcmyanmar.mmnews.kotlin.fragments.LoginFragment
import com.padcmyanmar.mmnews.kotlin.fragments.RegisterFragment
import kotlinx.android.synthetic.main.activity_account_control_2.*
import org.mmtextview.MMFontUtils

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

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        mAdapter = AccountControlAdapter(supportFragmentManager)
        mAdapter.addTab(LoginFragment(), "Login")
        mAdapter.addTab(RegisterFragment(), "Register")
        mAdapter.addTab(HighlightNewsFragment(), "Highlight News")

        pagerAccountControl.adapter = mAdapter
        pagerAccountControl.offscreenPageLimit = mAdapter.count

        tlAccountControl.setupWithViewPager(pagerAccountControl)
        tlAccountControl.getTabAt(0)!!.text = "Login XXX"
    }
}