package com.by.heatchart.data.index

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
class IndexHeatChartDataSet(var parts: Float = 100f, var data: MutableList<IndexHeatChartDataEntry> = mutableListOf()) {

    //region IndexHeatChartDataSet
    fun assignColorToRanges(color: Int) {
        data.forEach { it.color = color }
    }
    //endregion
}