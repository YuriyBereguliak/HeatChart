package com.by.hitchart.data

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
data class DrawRangeData(val startPoint: Int, val endPoint: Int, val rangeColor: Int = -1) {

    //region DrawRangeData
    fun isColorValid() = rangeColor != -1
    //endregion
}