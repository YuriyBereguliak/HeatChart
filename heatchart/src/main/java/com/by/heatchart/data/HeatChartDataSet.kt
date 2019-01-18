package com.by.heatchart.data

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
data class HeatChartDataSet(
    var parts: Float = 100f,
    var rangeData: MutableList<HeatChartEntry> = mutableListOf()
) {

    //region HeatChartDataSet
    fun assignColorToRanges(color: Int) {
        rangeData.forEach { it.rangeColor = color }
    }
    //endregion
}