package com.by.heatchart.data

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
data class HeatChartEntry(val startPoint: Int, val endPoint: Int, var rangeColor: Int = -1) {

    //region HeatChartEntry
    fun isColorValid() = rangeColor != -1
    //endregion
}