package com.by.hitchart.manager.chart

import com.by.hitchart.data.HeatChart
import com.by.hitchart.manager.draw.DrawManager

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
interface ChartManager {
    fun chartData(): HeatChart

    fun drawManager(): DrawManager
}