package com.by.heatchart.data.range

data class RangeHeatChartEntry(val startPoint: Int, val endPoint: Int, var rangeColor: Int = -1) {

    //region RangeHeatChartEntry
    fun isColorValid() = rangeColor != -1
    //endregion
}