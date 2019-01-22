package com.by.heatchart.core.view

import android.content.Context
import android.graphics.Canvas
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import com.by.heatchart.R
import com.by.heatchart.core.manager.DrawManager

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
abstract class BaseChartView<T>(context: Context, attrs: AttributeSet? = null) : View(context, attrs),
    ChartViewController<T> {

    private val chartManager: DrawManager<T> by lazy { initChartManager() }

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.BaseChartView)

            chartManager.chartData().chartColor = typedArray.getColor(
                R.styleable.BaseChartView_chartColor,
                ContextCompat.getColor(context, R.color.blue)
            )

            chartManager.chartData().frameColor = typedArray.getColor(
                R.styleable.BaseChartView_chartFrameColor,
                ContextCompat.getColor(context, R.color.gray_400)
            )

            chartManager.chartData().backgroundColor = typedArray.getColor(
                R.styleable.BaseChartView_chartBackgroundColor,
                ContextCompat.getColor(context, R.color.gray_400)
            )

            chartManager.chartData().separatorColor = typedArray.getColor(
                R.styleable.BaseChartView_chartSeparatorColor,
                ContextCompat.getColor(context, R.color.gray_400)
            )

            chartManager.chartData().frameBorderWidth = typedArray.getDimension(
                R.styleable.BaseChartView_chartFrameWidth,
                context.resources.getDimension(R.dimen.chart_border_width)
            )

            chartManager.chartData().frameSeparatorWidth = typedArray.getDimension(
                R.styleable.BaseChartView_chartFrameSeparatorWidth,
                context.resources.getDimension(R.dimen.chart_separator_width)
            )

            typedArray.recycle()
        }
    }

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