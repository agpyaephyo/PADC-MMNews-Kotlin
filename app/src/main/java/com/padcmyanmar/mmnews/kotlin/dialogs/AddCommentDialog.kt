package com.padcmyanmar.mmnews.kotlin.dialogs

import android.app.Dialog
import android.content.Context
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.delegates.AddCommentDelegate
import kotlinx.android.synthetic.main.dialog_add_new_comment.*

class AddCommentDialog : Dialog {

    private val mDelegate : AddCommentDelegate

    constructor(context: Context?, delegate : AddCommentDelegate) : super(context) {
        mDelegate = delegate
        setContentView(R.layout.dialog_add_new_comment)
        setCancelable(false)

        btnCancelAddComment.setOnClickListener {
            dismiss()
        }

        btnConfirmAddComment.setOnClickListener {
            val newComment = etComment.text.toString()
            if(!newComment.isEmpty()) {
                mDelegate.onAddNewComment(newComment)
            } else {
                etComment.error = "Cannot be empty"
            }
        }
    }
}