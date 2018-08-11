package com.padcmyanmar.mmnews.kotlin.views.pods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.padcmyanmar.mmnews.kotlin.data.models.LoginUserModel
import com.padcmyanmar.mmnews.kotlin.delegates.BeforeLoginDelegate
import com.padcmyanmar.mmnews.kotlin.events.UserSessionEvent
import kotlinx.android.synthetic.main.view_pod_account_control.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class AccountControlViewPod : FrameLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
        if (LoginUserModel.getInstance().isUserLogin()) {
            displayLoginUser()
        } else {
            displayBeforeLogin()
        }

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    fun setDelegate(delegate : BeforeLoginDelegate) {
        (vpBeforeLogin as BeforeLoginViewPod).setDelegate(delegate)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessLoginUser(event: UserSessionEvent.LoginUserSuccessEvent) {
        displayLoginUser()
    }

    private fun displayLoginUser() {
        vpLoginUser.visibility = View.VISIBLE
        vpBeforeLogin.visibility = View.GONE
    }

    private fun displayBeforeLogin() {
        vpLoginUser.visibility = View.GONE
        vpBeforeLogin.visibility = View.VISIBLE
    }
}