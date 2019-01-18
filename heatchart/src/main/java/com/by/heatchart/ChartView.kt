package com.by.heatchart

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.by.heatchart.data.HeatChartDataSet
import com.by.heatchart.manager.chart.ChartManager
import com.by.heatchart.manager.chart.HeatChartManager

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
class ChartView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val chartManager: ChartManager by lazy {
        HeatChartManager(context)
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
            chartManager.drawManager().draw(it)
        }
    }
    //endregion

    //region ChartView
    fun setChartData(dataSet: HeatChartDataSet) {
        post {
            chartManager.chartData().dataSet = dataSet
        }
    }
    //endregion
}