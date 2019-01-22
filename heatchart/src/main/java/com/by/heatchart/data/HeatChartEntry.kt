package com.by.heatchart.data

data class HeatChartEntry(val startPoint: Int, val endPoint: Int, var rangeColor: Int = -1) {

    //region HeatChartEntry
    fun isColorValid() = rangeColor != -1
    //endregion
}