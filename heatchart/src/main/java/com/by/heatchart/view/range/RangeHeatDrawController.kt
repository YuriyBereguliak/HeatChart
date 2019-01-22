package com.by.heatchart.view.range

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import com.by.heatchart.core.controller.BaseDrawController
import com.by.heatchart.data.ChartData
import com.by.heatchart.data.range.RangeHeatChartDataSet

class RangeHeatDrawController(context: Context, private var chartData: ChartData) :
    BaseDrawController<RangeHeatChartDataSet>(context, chartData) {

    private var rangePaint = Paint()

    init {
        contextReference.get()?.let {
            rangePaint.style = Paint.Style.FILL
            rangePaint.isAntiAlias = true
            rangePaint.color = chartData.chartColor
        }
    }

    //region DrawController
    override fun draw(canvas: Canvas, data: RangeHeatChartDataSet) {
        drawData(canvas, data)
        drawFrame(canvas)
    }
    //endregion

    //region Utility API
    private fun drawData(canvas: Canvas, data: RangeHeatChartDataSet) {
        val minPartWidth = chartData.calculateMinPart(data.parts)

        // Draw ranges from data set
        data.rangeData.forEach { rangeData ->
            val left = rangeData.startPoint * minPartWidth
            val right = rangeData.endPoint * minPartWidth

            val rect = RectF()
            rect.left = left
            rect.top = 0f
            rect.right = right
            rect.bottom = chartData.height.toFloat()

            if (rangeData.isColorValid()) {
                rangePaint.color = rangeData.rangeColor
            }

            canvas.drawRect(rect, rangePaint)
        }

        // Find empty ranges and apply color if needed
        if (!chartData.isBackgroundColorValid()) {
            return
        }
    }
    //endregion
}