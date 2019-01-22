package com.by.heatchart.view.range

import android.content.Context
import android.util.AttributeSet
import com.by.heatchart.core.view.BaseChartView
import com.by.heatchart.data.range.RangeHeatChartDataSet

/**
 * ChartData
 * Created by Yuriy Bereguliak on 1/18/19.
 */
class RangeHeatChartView(context: Context, attrs: AttributeSet? = null) :
    BaseChartView<RangeHeatChartDataSet>(context, attrs) {

    //region BaseChartView
    override fun initChartManager() = RangeHeatDrawManager(context)
    //endregion
}