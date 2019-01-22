package com.by.heatchart.view.index

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import com.by.heatchart.core.controller.BaseDrawController
import com.by.heatchart.data.ChartData
import com.by.heatchart.data.index.IndexHeatChartDataSet

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
class IndexHeatChartDrawController(context: Context, private var chartData: ChartData) :
    BaseDrawController<IndexHeatChartDataSet>(context, chartData) {

    private var rangePaint = Paint()
    private var borderPaint = Paint()

    init {
        contextReference.get()?.let {
            borderPaint.style = Paint.Style.STROKE
            borderPaint.isAntiAlias = true
            borderPaint.strokeWidth = chartData.frameSeparatorWidth
            borderPaint.color = chartData.separatorColor

            rangePaint.style = Paint.Style.FILL
            rangePaint.isAntiAlias = true
            rangePaint.color = chartData.chartColor
        }
    }

    //region BaseDrawController
    override fun draw(canvas: Canvas, data: IndexHeatChartDataSet) {
        drawData(canvas, data)
        drawElementsBounds(canvas, data)
        drawFrame(canvas)
    }
    //endregion

    //region Utility API
    private fun drawElementsBounds(canvas: Canvas, data: IndexHeatChartDataSet) {
        val minPartWidth = chartData.calculateMinPart(data.parts)

        for (i in 0..data.parts.toInt()) {
            val left = i * minPartWidth + minPartWidth
            canvas.drawLines(floatArrayOf(left, 0f, left, chartData.height.toFloat()), borderPaint)
        }
    }

    private fun drawData(canvas: Canvas, data: IndexHeatChartDataSet) {
        val minPartWidth = chartData.calculateMinPart(data.parts)

        data.data.forEach { entry ->
            val left = entry.index * minPartWidth
            val right = left + minPartWidth

            val rect = RectF()
            rect.left = left
            rect.top = 0f
            rect.right = right
            rect.bottom = chartData.height.toFloat()

            if (entry.isColorValid()) {
                rangePaint.color = entry.color
            }

            for (i in 0..entry.number) {
                canvas.drawRect(rect, rangePaint)
            }
        }
    }
    //endregion
}