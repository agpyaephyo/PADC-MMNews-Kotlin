package com.padcmyanmar.mmnews.kotlin.views.pods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.padcmyanmar.mmnews.kotlin.data.models.LoginUserModel
import com.padcmyanmar.mmnews.kotlin.data.vos.LoginUserVO
import com.padcmyanmar.mmnews.kotlin.events.UserSessionEvent
import kotlinx.android.synthetic.main.view_pod_login_user.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class LoginUserViewPod : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
        val loginUser = LoginUserModel.getInstance().getLoginUser()
        if (loginUser != null) {
            displayLoginUser(loginUser)
        }

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    private fun displayLoginUser(loginUser : LoginUserVO) {
        tvName.text = loginUser.name
        tvPhoneNo.text = loginUser.phoneNo

        Glide.with(context)
                .load(loginUser.profileUrl)
                .into(ivLoginUser)

        Glide.with(context)
                .load(loginUser.coverUrl)
                .into(ivLoginUserBg)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessLoginUser(event: UserSessionEvent.LoginUserSuccessEvent) {
        displayLoginUser(event.loginUser)
    }
}