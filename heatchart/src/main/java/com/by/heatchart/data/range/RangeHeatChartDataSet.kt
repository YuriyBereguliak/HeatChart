package com.by.heatchart.data.range

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
data class RangeHeatChartDataSet(
    var parts: Float = 100f,
    var rangeData: MutableList<RangeHeatChartEntry> = mutableListOf()
) {

    //region RangeHeatChartDataSet
    fun assignColorToRanges(color: Int) {
        rangeData.forEach { it.rangeColor = color }
    }
    //endregion
}