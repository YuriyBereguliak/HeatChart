package com.by.heatchart.data.index

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
data class IndexHeatChartDataEntry(val index: Int, val number: Int, var color: Int = -1) {
    //region IndexHeatChartDataEntry
    fun isColorValid() = color != -1
    //endregion
}