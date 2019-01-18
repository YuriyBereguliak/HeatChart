package com.by.hitchart.data

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
data class HeatChart(
    var width: Int = 0,
    var height: Int = 0,
    var parts: Int = 100,
    var rangeData: MutableList<DrawRangeData> = mutableListOf()
)