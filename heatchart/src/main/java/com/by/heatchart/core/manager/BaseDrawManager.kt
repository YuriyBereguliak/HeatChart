package com.by.heatchart.core.manager

import com.by.heatchart.core.controller.DrawController
import com.by.heatchart.data.ChartData

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
abstract class BaseDrawManager<T> : DrawManager<T> {

    protected val chart = ChartData()

    protected val drawController: DrawController<T> by lazy {
        initDrawController()
    }

    //region BaseDrawManager
    abstract fun initDrawController(): DrawController<T>
    //endregion

    //region DrawManager
    override fun chartData() = chart

    override fun release() {
        drawController.release()
    }
    //endregion
}