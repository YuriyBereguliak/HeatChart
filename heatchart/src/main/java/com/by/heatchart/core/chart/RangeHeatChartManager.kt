package com.by.heatchart.core.chart

import android.content.Context
import com.by.heatchart.data.HeatChart
import com.by.heatchart.manager.draw.DrawManager
import com.by.heatchart.manager.draw.HeatDrawManager

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
class RangeHeatChartManager(context: Context) : ChartManager {

    private var drawManager: DrawManager = HeatDrawManager(context)

    //region ChartManager
    override fun chartData(): HeatChart = drawManager.chartData()

    override fun drawManager(): DrawManager = drawManager
    //endregion
}