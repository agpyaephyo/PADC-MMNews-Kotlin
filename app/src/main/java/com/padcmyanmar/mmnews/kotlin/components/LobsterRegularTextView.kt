package com.padcmyanmar.mmnews.kotlin.components

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

class LobsterRegularTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {
        if (!isInEditMode)
            init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        if (!isInEditMode)
            init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        if (!isInEditMode)
            init(context)
    }

    private fun init(context: Context) {
        val t = Typeface.createFromAsset(context.assets, "fonts/Lobster-Regular.ttf")
        this.typeface = t
    }
}