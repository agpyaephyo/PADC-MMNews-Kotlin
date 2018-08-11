package com.padcmyanmar.mmnews.kotlin.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.padcmyanmar.mmnews.kotlin.R

class PageIndicatorView : View {
    private val VIEW_TAG = "PageIndicatorView"

    private val mPaintNormalFill = Paint(ANTI_ALIAS_FLAG)
    private val mPaintSelectFill = Paint(ANTI_ALIAS_FLAG)

    private var mPadding: Float = 0.toFloat()
    private var mRadius: Float = 0.toFloat()

    private var currentPage: Int = 0
    private var numPage: Int = 0

    constructor(context: Context) : super(context, null) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        this.mPaintNormalFill.style = Paint.Style.STROKE
        this.mPaintNormalFill.color = context.resources.getColor(R.color.grey)
        this.mPaintNormalFill.strokeWidth = 1.5f

        this.mPaintSelectFill.style = Paint.Style.FILL
        this.mPaintSelectFill.color = context.resources.getColor(R.color.white)

        this.numPage = 0
        this.currentPage = 0

        this.mRadius = getPixelFromDPI(context, 5f).toFloat()
        this.mPadding = getPixelFromDPI(context, 15f).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (this.numPage == 0)
            return

        if (this.currentPage >= this.numPage) {
            this.setCurrentPage(this.numPage - 1)
            return
        }

        //only redraw if valid condition
        val width = this.width
        val realWidth = this.calculateWith()

        //center circle object
        var dx = (width / 2.0 - realWidth / 2.0).toFloat()
        val dy = 0f
        //Log.d(VIEW_TAG, "onDraw>>>" + realWidth + "/ " + width + " / height " + this.getHeight());
        for (iLoop in 0 until this.numPage) {

            if (iLoop == this.currentPage) {
                canvas.drawCircle(dx + mRadius, dy + mRadius, mRadius, mPaintSelectFill)
            } else {
                canvas.drawCircle(dx + mRadius, dy + mRadius, mRadius, mPaintNormalFill)
            }

            dx += mRadius * 2 + mPadding
        }
    }

    private fun calculateWith(): Float {
        return (this.numPage - 1) * mPadding + this.numPage.toFloat() * this.mRadius * 2f + 1f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val newWidth = this.measureLong(widthMeasureSpec)
        val newHeight = this.measureShort(heightMeasureSpec)
        //Log.d(VIEW_TAG, "onMeasure>>>>>>>> " + newWidth + "/ " + newHeight);
        setMeasuredDimension(newWidth, newHeight)
    }

    /**
     * Determines the width of this view
     *
     * @param measureSpec A measureSpec packed into an int
     * @return The width of the view, honoring constraints from measureSpec
     */
    private fun measureLong(measureSpec: Int): Int {
        var result: Int
        val specMode = View.MeasureSpec.getMode(measureSpec)
        val specSize = View.MeasureSpec.getSize(measureSpec)

        if (specMode == View.MeasureSpec.EXACTLY) {
            //We were told how big to be
            result = specSize
        } else {
            //Calculate the width according the views count
            result = (paddingLeft.toFloat() + paddingRight.toFloat()
                    + this.calculateWith()).toInt()
            //Respect AT_MOST value if that was what is called for by measureSpec
            if (specMode == View.MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize)
            }
        }
        return result
    }

    /**
     * Determines the height of this view
     *
     * @param measureSpec A measureSpec packed into an int
     * @return The height of the view, honoring constraints from measureSpec
     */
    private fun measureShort(measureSpec: Int): Int {
        var result: Int
        val specMode = View.MeasureSpec.getMode(measureSpec)
        val specSize = View.MeasureSpec.getSize(measureSpec)

        if (specMode == View.MeasureSpec.EXACTLY) {
            //We were told how big to be
            result = specSize
        } else {
            //Measure the height
            result = (2 * mRadius + paddingTop.toFloat() + paddingBottom.toFloat() + 1f).toInt()
            //Respect AT_MOST value if that was what is called for by measureSpec
            if (specMode == View.MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize)
            }
        }
        return result
    }

    //public method
    fun setNumPage(num: Int) {
        this.numPage = num
        this.invalidate()
    }

    fun setCurrentPage(currentNum: Int) {
        this.currentPage = currentNum
        this.invalidate()
    }

    /**
     * Get pixel from dpi.
     *
     * @param dpi
     * @return
     */
    private fun getPixelFromDPI(context: Context, dpi: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpi, context.resources.displayMetrics).toInt()
    }

}