package com.by.heatchart.view.index

import android.content.Context
import android.util.AttributeSet
import com.by.heatchart.core.view.BaseChartView
import com.by.heatchart.data.index.IndexHeatChartDataSet

/**
 * HitChart
 * Created by Yuriy Bereguliak on 1/22/19.
 */
class IndexHeatChartView(context: Context, attrs: AttributeSet? = null) :
    BaseChartView<IndexHeatChartDataSet>(context, attrs) {

    //region BaseChartView
    override fun initChartManager() = IndexHeatChartDrawManager(context)
    //endregion
}