package com.by.heatchart.manager.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.support.v4.content.ContextCompat
import com.by.heatchart.R
import com.by.heatchart.data.HeatChart

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
class HeatDrawController(
    context: Context,
    private var data: HeatChart
) {

    private var framePaint: Paint
    private var rangePaint: Paint

    init {
        val res = context.resources

        framePaint = Paint()
        framePaint.style = Paint.Style.STROKE
        framePaint.isAntiAlias = true
        framePaint.strokeWidth = res.getDimension(R.dimen.frame_line_width)
        framePaint.color = ContextCompat.getColor(context, R.color.gray_400)

        rangePaint = Paint()
        rangePaint.style = Paint.Style.FILL
        rangePaint.isAntiAlias = true
        rangePaint.color = ContextCompat.getColor(context, R.color.blue)
    }

    //region HeatDrawController
    fun draw(canvas: Canvas) {
        drawFrame(canvas)
        drawData(canvas)
    }
    //endregion

    //region Utility API
    private fun drawFrame(canvas: Canvas) {
        val rect = Rect()
        rect.top = 0
        rect.left = 0
        rect.right = data.width
        rect.bottom = data.height

        canvas.drawRect(rect, framePaint)
    }

    private fun drawData(canvas: Canvas) {
        val minPartWidth = data.calculateMinPart()

        data.rangeData.forEach { rangeData ->
            val left = rangeData.startPoint * minPartWidth
            val right = rangeData.endPoint * minPartWidth

            val rect = RectF()
            rect.left = left
            rect.top = 0f
            rect.right = right
            rect.bottom = data.height.toFloat()

            if (rangeData.isColorValid()) {
                rangePaint.color = rangeData.rangeColor
            }

            canvas.drawRect(rect, rangePaint)
        }
    }
    //endregion
}