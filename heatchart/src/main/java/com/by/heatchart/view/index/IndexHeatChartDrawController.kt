package com.by.heatchart.view.index

import android.content.Context
import android.graphics.Canvas
import com.by.heatchart.core.controller.BaseDrawController
import com.by.heatchart.data.ChartData
import com.by.heatchart.data.index.IndexHeatChartDataSet

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
class IndexHeatChartDrawController(context: Context, chartData: ChartData) :
    BaseDrawController<IndexHeatChartDataSet>(context, chartData) {

    //region BaseDrawController
    override fun draw(canvas: Canvas, data: IndexHeatChartDataSet) {
        drawFrame(canvas)
        drawData(canvas, data)
    }
    //endregion

    //region Utility API
    private fun drawData(canvas: Canvas, data: IndexHeatChartDataSet) {

    }
    //endregion
}