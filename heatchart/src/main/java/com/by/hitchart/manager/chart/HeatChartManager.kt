package com.by.hitchart.manager.chart

import android.content.Context
import com.by.hitchart.data.HeatChart
import com.by.hitchart.manager.draw.DrawManager
import com.by.hitchart.manager.draw.HeatDrawManager

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
class HeatChartManager(context: Context) : ChartManager {

    private var drawManager: DrawManager = HeatDrawManager(context)

    //region ChartManager
    override fun chartData(): HeatChart = drawManager.chartData()

    override fun drawManager(): DrawManager = drawManager
    //endregion
}