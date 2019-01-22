package com.by.heatchart.core.chart

import com.by.heatchart.data.ChartData
import com.by.heatchart.core.manager.DrawManager

/**
 * ChartData
 * Created by Yuriy Bereguliak on 1/18/19.
 */
interface ChartManager<T> {
    fun chartData(): ChartData

    fun drawManager(): DrawManager<T>
}