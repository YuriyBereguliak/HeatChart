package com.by.heatchart.data

data class ChartData(
    var width: Int = 0,
    var height: Int = 0,
    var isApplyToEmptyRangeColor: Boolean = false,
    var backgroundColor: Int = -1
) {

    //region ChartData
    fun isBackgroundColorValid() = backgroundColor != -1 && isApplyToEmptyRangeColor

    fun calculateMinPart(parts: Float): Float = width / parts
    //endregion
}