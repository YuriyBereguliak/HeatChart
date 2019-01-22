package com.by.heatchart.view.range.manager

import android.content.Context
import android.graphics.Canvas
import com.by.heatchart.core.manager.BaseDrawManager
import com.by.heatchart.data.range.RangeHeatChartDataSet
import com.by.heatchart.view.range.controller.RangeHeatDrawController

/**
 * ChartData
 * Created by Yuriy Bereguliak on 1/18/19.
 */
class RangeHeatDrawManager(private val context: Context) : BaseDrawManager<RangeHeatChartDataSet>() {

    private var dataSet = RangeHeatChartDataSet()

    //region BaseDrawManager
    override fun initDrawController() = RangeHeatDrawController(context, chart)
    //endregion

    //region DrawManager
    override fun dataSet(dataSet: RangeHeatChartDataSet) {
        this.dataSet = dataSet
    }

    override fun draw(canvas: Canvas) {
        drawController.draw(canvas, dataSet)
    }
    //endregion
}