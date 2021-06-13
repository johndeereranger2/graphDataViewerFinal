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
                var mChart: HorizontalBarChart = it
                val labels: ArrayList<String> = ArrayList()
                labels.add("0.0")
                labels.add("0.5")
                labels.add("1.0")
                labels.add("1.5")
                labels.add("2.0")
                labels.add("2.5")

                mChart.setDrawBarShadow(false)
                mChart.setDrawValueAboveBar(true)
                mChart.getDescription().setEnabled(false)
                mChart.setPinchZoom(false)
                mChart.setDrawGridBackground(false)
                mChart.getLegend().setTextColor(Color.BLACK);


                val xl: XAxis = mChart.getXAxis()

                xl.setTextColor(Color.WHITE)

                xl.position = XAxis.XAxisPosition.BOTTOM
                xl.setDrawAxisLine(true)
                xl.setDrawGridLines(false)
                xl.setValueFormatter(object :
                    ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        // return the string va
                        val `val` = value.toInt()
                        var label = ""
                        label = if (`val` >= 0 && `val` < labels.size) {
                            labels.get(`val`)
                        } else {
                            ""
                        }
                        return label
                    }
                })
                xl.granularity = 1f

                val yl: YAxis = mChart.getAxisLeft()

                yl.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
                yl.setDrawGridLines(false)
                yl.isEnabled = false
                yl.axisMinimum = 0f

                val yr: YAxis = mChart.getAxisRight()
                yr.setTextColor(Color.WHITE)

                yr.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
                yr.setDrawGridLines(false)
                yr.axisMinimum = 0f


                val yVals1 = ArrayList<BarEntry>()
                for (i in 0..5) {
                    var result: Float = (i + 1 * 10).toFloat()

                    yVals1.add(BarEntry(i.toFloat(), result))
                }

                mChart.setExtraOffsets(5f, 5f, 5f, 15f)


                val set1: BarDataSet
                set1 = BarDataSet(yVals1, heading)
                val dataSets = ArrayList<IBarDataSet>()
                dataSets.add(set1)

                val data = BarData(dataSets)


                set1.setColor(Color.WHITE)
                data.setDrawValues(false)

                data.setValueTextSize(10f)
                data.barWidth = .2f
                mChart.setData(data)
                mChart.getLegend().setEnabled(true)

            }

        }
        if (position == 1) {

            barview.visibility = View.VISIBLE
            piechart.visibility = View.GONE
            barchart?.let {
                var mChart: HorizontalBarChart = it
                // pass list here
                val labels: ArrayList<String> = ArrayList()
                labels.add("0.0")
                labels.add("0.5")
                labels.add("1.0")
                labels.add("1.5")
                labels.add("2.0")
                labels.add("2.5")
                // pass labels list here
                val ylabels: ArrayList<String> = ArrayList()
                ylabels.add("New")
                ylabels.add("Full")
                ylabels.add("Full Moon")

                mChart.setDrawBarShadow(false)
                mChart.setDrawValueAboveBar(true)
                mChart.getDescription().setEnabled(false)
                mChart.setPinchZoom(false)
                mChart.setDrawGridBackground(false)
                mChart.getLegend().setTextColor(Color.BLACK);


                val xl: XAxis = mChart.getXAxis()

                xl.setTextColor(Color.WHITE)

                xl.position = XAxis.XAxisPosition.BOTTOM
                xl.setDrawAxisLine(true)
                xl.setDrawGridLines(false)
                xl.setValueFormatter(object :
                    ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        // return the string va
                        val `val` = value.toInt()
                        var label = ""
                        label = if (`val` >= 0 && `val` < labels.size) {
                            labels.get(`val`)
                        } else {
                            ""
                        }
                        return label
                    }
                })

                xl.granularity = 1f

                val yl: YAxis = mChart.getAxisLeft()

                yl.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
                yl.setDrawGridLines(false)
                yl.isEnabled = false
                yl.axisMinimum = 0f

                val yr: YAxis = mChart.getAxisRight()
                yr.setTextColor(Color.WHITE)

                yr.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
                yr.setDrawGridLines(false)
                yr.axisMinimum = 0f

                var count = 0
                val yVals1 = ArrayList<BarEntry>()
                yr.setValueFormatter(object :
                    ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        // return the string va
                        val `val` = count.toInt()
                        count++

                        var label = ""
                        label = if (`val` >= 0 && `val` < ylabels.size) {
                            ylabels.get(`val`)
                        } else {
                            ""
                        }
                        return label
                    }
                })
                for (i in 0..5) {
                    var result: Float = (i + 1 * 10).toFloat()

                    yVals1.add(BarEntry(i.toFloat(), result))
                }

                mChart.setExtraOffsets(5f, 5f, 5f, 15f)


                val set1: BarDataSet
                set1 = BarDataSet(yVals1, heading)
                val dataSets = ArrayList<IBarDataSet>()
                dataSets.add(set1)

                val data = BarData(dataSets)


                set1.setColor(Color.WHITE)
                data.setDrawValues(false)

                data.setValueTextSize(10f)
                data.barWidth = .4f
                mChart.setData(data)
                mChart.getLegend().setEnabled(true)

            }

        }
        if (position == 2) {
            barview.visibility = View.GONE
            piechart.visibility = View.VISIBLE
            val windowManager =
                getSystemService(Context.WINDOW_SERVICE) as WindowManager

            // will adjust according to every screen
            val strokewidth: Int = ScreenResolutionForResult(windowManager)
            val pair: Pair<Int, Int> =
                animatePieViewResolution(windowManager)
            AnimateView(strokewidth, pair)
        }
    }

    private fun AnimateView( strokewidth: Int, pair: Pair<Int, Int>) {

        var pieView = piechart

        val time = floatArrayOf(55f, 95f, 30f, 360 - (55 + 95 + 30).toFloat())
        val activity =
            arrayOf("Jan", "Feb", "March", "")
        val pieEntires: MutableList<PieEntry> = ArrayList()
        for (i in 0 until time.size) {
            pieEntires.add(PieEntry(time[i], activity[i]))
        }
        val config = AnimatedPieViewConfig()
        for (info in time) {
            val rnd = Random()
            val color = Color.argb(
                255,
                rnd.nextInt(256),
                rnd.nextInt(256),
                rnd.nextInt(256)
            )

            config.addData(SimplePieInfo(info.toDouble(),color,""))
        }

        config.startAngle(-90f) // start angle offset
            .splitAngle(0.9649358f)
            .drawText(true)
            .duration(1200)
            .pieRadiusRatio(1.0f)
            .textSize(pair.first.toFloat())
            .pieRadius(pair.second.toFloat()) //                    .textMargin(5)// Margin between text and guide line
            .autoSize(true)
            .strokeWidth(strokewidth)
            .focusAlphaType(AnimatedPieViewConfig.FOCUS_WITH_ALPHA)
            .textGravity(AnimatedPieViewConfig.ABOVE)
            .interpolator(DecelerateInterpolator())
        pieView?.applyConfig(config)
        pieView?.start()

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