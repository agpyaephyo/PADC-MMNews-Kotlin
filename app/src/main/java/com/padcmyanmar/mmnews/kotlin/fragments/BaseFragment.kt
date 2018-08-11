package com.padcmyanmar.mmnews.kotlin.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v4.app.Fragment
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import com.padcmyanmar.mmnews.kotlin.events.ErrorEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

open class BaseFragment : Fragment() {
    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun onStop() {
        super.onStop()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onApiErrorEvent(event : ErrorEvent.ApiErrorEvent) {
        showErrorMsg(event.getMsg()!!)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyDataLoadedEvent(event : DataEvent.EmptyDataLoadedEvent) {
        showErrorMsg(event.errorMsg!!)
    }

    private fun showErrorMsg(errorMsg : String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error in Network Call")
                .setMessage(errorMsg)
                .setCancelable(false)
        val dialog = builder.create()
        dialog.show()
    }
}