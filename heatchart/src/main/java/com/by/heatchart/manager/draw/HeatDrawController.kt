package com.by.heatchart.manager.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.support.v4.content.ContextCompat
import com.by.heatchart.R
import com.by.heatchart.data.HeatChart

class HeatDrawController(
    private var context: Context?,
    private var heatChart: HeatChart
) {

    private var framePaint = Paint()
    private var rangePaint = Paint()

    init {
        context?.let {
            val res = it.resources

            framePaint.style = Paint.Style.STROKE
            framePaint.isAntiAlias = true
            framePaint.strokeWidth = res.getDimension(R.dimen.frame_line_width)
            framePaint.color = ContextCompat.getColor(it, R.color.gray_400)

            rangePaint.style = Paint.Style.FILL
            rangePaint.isAntiAlias = true
            rangePaint.color = ContextCompat.getColor(it, R.color.blue)
        }
    }

    //region HeatDrawController
    fun draw(canvas: Canvas) {
        drawFrame(canvas)
        drawData(canvas)
    }

    fun release() {
        context = null
    }
    //endregion

    //region Utility API
    private fun drawFrame(canvas: Canvas) {
        val rect = Rect()
        rect.top = 0
        rect.left = 0
        rect.right = heatChart.width
        rect.bottom = heatChart.height

        canvas.drawRect(rect, framePaint)
    }

    private fun drawData(canvas: Canvas) {
        val minPartWidth = heatChart.calculateMinPart()

        // Draw ranges from data set
        heatChart.dataSet.rangeData.forEach { rangeData ->
            val left = rangeData.startPoint * minPartWidth
            val right = rangeData.endPoint * minPartWidth

            val rect = RectF()
            rect.left = left
            rect.top = 0f
            rect.right = right
            rect.bottom = heatChart.height.toFloat()

            if (rangeData.isColorValid()) {
                rangePaint.color = rangeData.rangeColor
            }

            canvas.drawRect(rect, rangePaint)
        }

        // Find empty ranges and apply color if needed
        if (!heatChart.isBackgroundColorValid()) {
            return
        }
    }
    //endregion
}