package com.by.hitchart.data

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
data class HeatChart(
    var width: Int = 0,
    var height: Int = 0,
    var parts: Float = 100.0f,
    var rangeData: MutableList<DrawRangeData> = mutableListOf()
) {

    //region HeatChart
    fun calculateMinPart(): Float = width / parts
    //endregion
}