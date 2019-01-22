package com.by.heatchart.core.chart

import com.by.heatchart.data.HeatChart
import com.by.heatchart.manager.draw.DrawManager

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
interface ChartManager {
    fun chartData(): HeatChart

    fun drawManager(): DrawManager
}