package com.by.heatchart.core.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.by.heatchart.core.manager.DrawManager

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
abstract class BaseChartView<T>(context: Context, attrs: AttributeSet? = null) : View(context, attrs),
    ChartViewController<T> {

    private val chartManager: DrawManager<T> by lazy { initChartManager() }

    //region BaseChartView
    abstract fun initChartManager(): DrawManager<T>
    //endregion

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

    //region ChartViewController
    override fun dataSet(dataSet: T) {
        post {
            chartManager.dataSet(dataSet)
        }
    }

    override fun release() {
        chartManager.release()
    }
    //endregion
}