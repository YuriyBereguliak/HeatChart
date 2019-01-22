package com.by.heatchart.core.view

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
interface ChartViewController<in T> {
    fun dataSet(dataSet: T)

    fun release()
}