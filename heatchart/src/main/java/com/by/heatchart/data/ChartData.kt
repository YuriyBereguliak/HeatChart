package com.by.heatchart.data

data class ChartData(
    var width: Int = 0,
    var height: Int = 0,
    var isApplyToEmptyRangeColor: Boolean = false,
    var backgroundColor: Int = -1,
    var frameColor: Int = -1,
    var separatorColor: Int = -1,
    var chartColor: Int = -1,
    var frameBorderWidth: Float = -1f,
    var frameSeparatorWidth: Float = -1f
) {

    //region ChartData
    fun isBackgroundColorValid() = backgroundColor != -1 && isApplyToEmptyRangeColor

    fun calculateMinPart(parts: Float): Float = width / parts
    //endregion
}