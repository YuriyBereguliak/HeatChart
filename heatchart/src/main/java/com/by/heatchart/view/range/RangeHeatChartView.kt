package com.by.heatchart.view.range

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.by.heatchart.data.range.RangeHeatChartDataSet
import com.by.heatchart.view.range.manager.RangeHeatDrawManager

/**
 * ChartData
 * Created by Yuriy Bereguliak on 1/18/19.
 */
class RangeHeatChartView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val chartManager by lazy {
        RangeHeatDrawManager(context)
    }

    //region View
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)
        chartManager.chartData().width = width
        chartManager.chartData().height = height
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            chartManager.draw(it)
        }
    }
    //endregion

    //region RangeHeatChartView
    fun setChartData(dataSetRange: RangeHeatChartDataSet) {
        post {
            chartManager.dataSet(dataSetRange)
            invalidate()
        }
    }
    //endregion
}