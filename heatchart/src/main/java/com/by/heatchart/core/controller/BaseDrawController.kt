package com.by.heatchart.core.controller

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.annotation.CallSuper
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
            framePaint.style = Paint.Style.STROKE
            framePaint.isAntiAlias = true
            framePaint.strokeWidth = chartData.frameBorderWidth
            framePaint.color = chartData.frameColor
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