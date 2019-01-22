package com.bereguliak.yuriy.hitchart

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.by.heatchart.data.index.IndexHeatChartDataEntry
import com.by.heatchart.data.index.IndexHeatChartDataSet
import com.by.heatchart.data.range.RangeHeatChartDataSet
import com.by.heatchart.data.range.RangeHeatChartEntry
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //region AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFirstRangeChart()

        initSecondCustomRangeChart()

        initThirdIndexChart()
    }
    //endregion

    //region Utility API
    private fun initFirstRangeChart() {
        val mutableListFirst = mutableListOf<RangeHeatChartEntry>()
        with(mutableListFirst) {
            add(RangeHeatChartEntry(0, 20))
            add(RangeHeatChartEntry(10, 25))
            add(RangeHeatChartEntry(12, 20))
            add(RangeHeatChartEntry(15, 18))
            add(RangeHeatChartEntry(35, 44))
            add(RangeHeatChartEntry(40, 50))
            add(RangeHeatChartEntry(43, 55))
            add(RangeHeatChartEntry(45, 70))
            add(RangeHeatChartEntry(80, 90))
            add(RangeHeatChartEntry(85, 98))
            add(RangeHeatChartEntry(88, 100))
        }
        topChartView.dataSet(RangeHeatChartDataSet(rangeData = mutableListFirst))
    }

    private fun initSecondCustomRangeChart() {
        val mutableListWithColor = mutableListOf<RangeHeatChartEntry>()
        with(mutableListWithColor) {
            add(RangeHeatChartEntry(0, 20))
            add(RangeHeatChartEntry(10, 25))
            add(RangeHeatChartEntry(45, 70))
            add(RangeHeatChartEntry(75, 90))
            add(RangeHeatChartEntry(80, 90))
            add(RangeHeatChartEntry(85, 95))
        }

        val dataSet = RangeHeatChartDataSet()
        dataSet.parts = 100f
        dataSet.rangeData = mutableListWithColor
        dataSet.assignColorToRanges(ContextCompat.getColor(this, R.color.green))

        secondChart.dataSet(dataSet)
    }

    private fun initThirdIndexChart() {
        val mutableList = mutableListOf<IndexHeatChartDataEntry>()

        with(mutableList) {
            add(IndexHeatChartDataEntry(0, 2))
            add(IndexHeatChartDataEntry(2, 1))
            add(IndexHeatChartDataEntry(5, 6))
            add(IndexHeatChartDataEntry(7, 3))
        }

        indexChartView.dataSet(IndexHeatChartDataSet(10f, mutableList))
    }
    //endregion
}
