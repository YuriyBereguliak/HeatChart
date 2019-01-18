package com.by.heatchart.data

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
data class HeatChart(
    var width: Int = 0,
    var height: Int = 0,
    var backgroundColor: Int = -1,
    var dataSet: HeatChartDataSet = HeatChartDataSet()
) {

    //region HeatChart
    fun isBackgroundColorValid() = backgroundColor != -1

    fun calculateMinPart(): Float = width / dataSet.parts
    //endregion
}