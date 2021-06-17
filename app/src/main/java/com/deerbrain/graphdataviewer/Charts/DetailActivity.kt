package com.deerbrain.graphdataviewer.Charts

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import com.deerbrain.graphdataviewer.ChartsAdapter
import com.deerbrain.graphdataviewer.DeerChartCalcs
import com.deerbrain.graphdataviewer.DeerChartCalcs.Companion.sightingsPerCam
import com.deerbrain.graphdataviewer.R
import com.deerbrain.graphdataviewer.Utill.ScreenResolutionForResult
import com.deerbrain.graphdataviewer.Utill.animatePieViewResolution
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo
import kotlinx.android.synthetic.main.activity_data_recycler.*
import kotlinx.android.synthetic.main.activity_data_recycler.lay1
import kotlinx.android.synthetic.main.activity_data_recycler.lay2
import kotlinx.android.synthetic.main.activity_data_recycler.lay3
import kotlinx.android.synthetic.main.activity_data_recycler.lay4
import kotlinx.android.synthetic.main.activity_data_recycler.lay5
import kotlinx.android.synthetic.main.activity_data_recycler.lay6
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*
import kotlin.collections.ArrayList

class DetailActivity : AppCompatActivity() {
    var position = -1
    var heading = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setOnClicklisteners()

        position = intent.getStringExtra("pos")?.toInt()!!
        heading = intent.getStringExtra("heading")!!

        setData()
    }

    private fun setData() {
        if (position == 0) {
            barview?.visibility = View.VISIBLE
            piechart?.visibility = View.GONE

            barchart?.let {

                var chart = DeerChartView(this,it)
                chart.setValues(DeerChartCalcs.hourOfDayData())

            }

        }
        if (position == 1) {

            barview.visibility = View.VISIBLE
            piechart.visibility = View.GONE
            barchart?.let {
                var chart = DeerChartView(this,it)
                chart.setValues(DeerChartCalcs.timeSince6AM())

            }

        }
        if (position == 2) {
            barview.visibility = View.GONE
            piechart.visibility = View.VISIBLE
            var pieChartView = DeerPieChartView(piechart)
            pieChartView.setValueForPieView(this,sightingsPerCam())
        }
    }


    private fun setOnClicklisteners() {
        lay1?.setOnClickListener {
            setData()
            lay1?.setBackgroundResource(R.drawable.bg_rect_select)
            lay2?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(0)

        }
        lay2?.setOnClickListener {
            setData()

            lay2?.setBackgroundResource(R.drawable.bg_rect_select)
            lay1?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(0)

        }
        lay3?.setOnClickListener {
            setData()

            lay2?.setBackgroundResource(0)
            lay1?.setBackgroundResource(0)
            lay3?.setBackgroundResource(R.drawable.bg_rect_select)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(0)
        }
        lay4?.setOnClickListener {
            setData()

            lay1?.setBackgroundResource(0)
            lay2?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(R.drawable.bg_rect_select)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(0)

        }
        lay5?.setOnClickListener {
            setData()

            lay1?.setBackgroundResource(0)
            lay2?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(R.drawable.bg_rect_select)
            lay6?.setBackgroundResource(0)

        }

        lay6?.setOnClickListener{

            lay1?.setBackgroundResource(0)
            lay2?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(R.drawable.bg_rect_select)

        }



        layall?.setOnClickListener {
            setData()

            layall?.setBackgroundResource(R.drawable.bg_rect_select)
            laydaylight?.setBackgroundResource(0)
            layNight?.setBackgroundResource(0)


        }
        laydaylight?.setOnClickListener{
            setData()

            laydaylight?.setBackgroundResource(R.drawable.bg_rect_select)
            layall?.setBackgroundResource(0)
            layNight?.setBackgroundResource(0)


        }
        layNight?.setOnClickListener{
            setData()

            layNight?.setBackgroundResource(R.drawable.bg_rect_select)
            layall?.setBackgroundResource(0)
            laydaylight?.setBackgroundResource(0)


        }



        layall2?.setOnClickListener {
            setData()

            layall2?.setBackgroundResource(R.drawable.bg_rect_select)
            layAM?.setBackgroundResource(0)
            layPM?.setBackgroundResource(0)


        }
        layAM?.setOnClickListener {
            setData()

            layAM?.setBackgroundResource(R.drawable.bg_rect_select)
            layall2?.setBackgroundResource(0)
            layPM?.setBackgroundResource(0)


        }
        layPM?.setOnClickListener {
            setData()

            layPM?.setBackgroundResource(R.drawable.bg_rect_select)
            layall2?.setBackgroundResource(0)
            layAM?.setBackgroundResource(0)


        }


        layall3?.setOnClickListener {
            layall3?.setBackgroundResource(R.drawable.bg_rect_select)
            layqtr1?.setBackgroundResource(0)
            layQTR2?.setBackgroundResource(0)
            layqtr3?.setBackgroundResource(0)
            layqtr4?.setBackgroundResource(0)


        }
        layqtr1?.setOnClickListener {
            layqtr1?.setBackgroundResource(R.drawable.bg_rect_select)
            layall3?.setBackgroundResource(0)
            layQTR2?.setBackgroundResource(0)
            layqtr3?.setBackgroundResource(0)
            layqtr4?.setBackgroundResource(0)


        }
        layQTR2?.setOnClickListener {
            layQTR2?.setBackgroundResource(R.drawable.bg_rect_select)
            layqtr1?.setBackgroundResource(0)
            layall3?.setBackgroundResource(0)
            layqtr3?.setBackgroundResource(0)
            layqtr4?.setBackgroundResource(0)


        }
        layqtr3?.setOnClickListener {
            layqtr3?.setBackgroundResource(R.drawable.bg_rect_select)
            layqtr1?.setBackgroundResource(0)
            layQTR2?.setBackgroundResource(0)
            layall3?.setBackgroundResource(0)
            layqtr4?.setBackgroundResource(0)


        }
        layqtr4?.setOnClickListener {
            layqtr4?.setBackgroundResource(R.drawable.bg_rect_select)
            layqtr1?.setBackgroundResource(0)
            layQTR2?.setBackgroundResource(0)
            layqtr3?.setBackgroundResource(0)
            layall3?.setBackgroundResource(0)


        }


    }

}