package com.bereguliak.yuriy.hitchart

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.by.heatchart.data.HeatChartDataSet
import com.by.heatchart.data.HeatChartEntry
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mutableListFirst = mutableListOf<HeatChartEntry>()
        with(mutableListFirst) {
            add(HeatChartEntry(0, 20))
            add(HeatChartEntry(10, 25))
            add(HeatChartEntry(12, 20))
            add(HeatChartEntry(15, 18))
            add(HeatChartEntry(35, 44))
            add(HeatChartEntry(40, 50))
            add(HeatChartEntry(43, 55))
            add(HeatChartEntry(45, 70))
            add(HeatChartEntry(80, 90))
            add(HeatChartEntry(85, 98))
            add(HeatChartEntry(88, 100))
        }
        topChartView.setChartData(HeatChartDataSet(rangeData = mutableListFirst))

        val mutableListWithColor = mutableListOf<HeatChartEntry>()
        with(mutableListWithColor) {
            add(HeatChartEntry(0, 20))
            add(HeatChartEntry(10, 25))
            add(HeatChartEntry(45, 70))
            add(HeatChartEntry(75, 90))
            add(HeatChartEntry(80, 90))
            add(HeatChartEntry(85, 95))
        }

        val dataSet = HeatChartDataSet()
        dataSet.parts = 100f
        dataSet.rangeData = mutableListWithColor
        dataSet.assignColorToRanges(ContextCompat.getColor(this, R.color.green))

        secondChart.setChartData(dataSet)
    }
}
