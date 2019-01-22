package com.by.heatchart.core.controller

import android.graphics.Canvas

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
interface DrawController<in T> {
    fun draw(canvas: Canvas, data: T)

    fun release()
}