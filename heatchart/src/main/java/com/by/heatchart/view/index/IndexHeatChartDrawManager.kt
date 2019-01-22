package com.by.heatchart.view.index

import android.content.Context
import android.graphics.Canvas
import com.by.heatchart.core.manager.BaseDrawManager
import com.by.heatchart.data.index.IndexHeatChartDataSet

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
class IndexHeatChartDrawManager(private val context: Context) : BaseDrawManager<IndexHeatChartDataSet>() {

    private var dataSet = IndexHeatChartDataSet()

    //region BaseDrawManager
    override fun initDrawController() = IndexHeatChartDrawController(context, chart)
    //endregion

    //region Description
    override fun draw(canvas: Canvas) {
        drawController.draw(canvas, dataSet)
    }

    override fun dataSet(dataSet: IndexHeatChartDataSet) {
        this.dataSet = dataSet
    }
    //endregion
}