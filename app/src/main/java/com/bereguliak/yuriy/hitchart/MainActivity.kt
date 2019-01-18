package com.bereguliak.yuriy.hitchart

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.by.hitchart.data.DrawRangeData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mutableListFirst = mutableListOf<DrawRangeData>()
        mutableListFirst.add(DrawRangeData(0, 20))
        mutableListFirst.add(DrawRangeData(10, 25))
        mutableListFirst.add(DrawRangeData(12, 20))
        mutableListFirst.add(DrawRangeData(15, 18))
        mutableListFirst.add(DrawRangeData(35, 44))
        mutableListFirst.add(DrawRangeData(40, 50))
        mutableListFirst.add(DrawRangeData(43, 55))
        mutableListFirst.add(DrawRangeData(45, 70))
        mutableListFirst.add(DrawRangeData(80, 90))
        mutableListFirst.add(DrawRangeData(85, 98))
        mutableListFirst.add(DrawRangeData(88, 100))
        topChartView.setChartData(mutableListFirst)
    }
}
