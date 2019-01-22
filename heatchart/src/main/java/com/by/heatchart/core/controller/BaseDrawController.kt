package com.by.heatchart.core.controller

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.annotation.CallSuper
import android.support.v4.content.ContextCompat
import com.by.heatchart.R
import com.by.heatchart.data.ChartData
import java.lang.ref.WeakReference

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
abstract class BaseDrawController<in T>(context: Context, private val chartData: ChartData) : DrawController<T> {

    protected val contextReference = WeakReference(context)
    private var framePaint = Paint()

    init {
        contextReference.get()?.let {
            val res = it.resources

            framePaint.style = Paint.Style.STROKE
            framePaint.isAntiAlias = true
            framePaint.strokeWidth = res.getDimension(R.dimen.frame_line_width)
            framePaint.color = ContextCompat.getColor(it, R.color.gray_400)
        }
    }

    //region BaseDrawController
    protected fun drawFrame(canvas: Canvas) {
        val rect = Rect()
        rect.top = 0
        rect.left = 0
        rect.right = chartData.width
        rect.bottom = chartData.height

        canvas.drawRect(rect, framePaint)
    }
    //endregion

    //region DrawController
    @CallSuper
    override fun release() {
        contextReference.clear()
    }
    //endregion
}