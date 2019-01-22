package com.by.heatchart.data

data class HeatChart(
    var width: Int = 0,
    var height: Int = 0,
    var isApplyToEmptyRangeColor: Boolean = false,
    var backgroundColor: Int = -1,
    var dataSet: HeatChartDataSet = HeatChartDataSet()
) {

    //region HeatChart
    fun isBackgroundColorValid() = backgroundColor != -1 && isApplyToEmptyRangeColor

    fun calculateMinPart(): Float = width / dataSet.parts
    //endregion
}