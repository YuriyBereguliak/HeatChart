package com.by.heatchart.manager.draw

import android.graphics.Canvas
import com.by.heatchart.data.HeatChart

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
interface DrawManager {
    fun chartData(): HeatChart

    fun draw(canvas: Canvas)
}