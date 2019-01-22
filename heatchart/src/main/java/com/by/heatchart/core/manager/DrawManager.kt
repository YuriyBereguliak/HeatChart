package com.by.heatchart.core.manager

import android.graphics.Canvas
import com.by.heatchart.data.ChartData

/**
 * ChartData
 * Created by Yuriy Bereguliak on 1/18/19.
 */
interface DrawManager<in T> {
    fun chartData(): ChartData

    fun draw(canvas: Canvas)

    fun dataSet(dataSet: T)

    fun release()
}