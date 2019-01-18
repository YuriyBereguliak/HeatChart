package com.by.hitchart.manager.draw

import android.content.Context
import android.graphics.Canvas
import com.by.hitchart.data.HeatChart

/**
 * HeatChart
 * Created by Yuriy Bereguliak on 1/18/19.
 */
class HeatDrawManager(context: Context) : DrawManager {

    private val chart = HeatChart()
    private val drawController = HeatDrawController(context, chart)

    //region DrawManager
    override fun chartData() = chart

    override fun draw(canvas: Canvas) {
        drawController.draw(canvas)
    }
    //endregion
}