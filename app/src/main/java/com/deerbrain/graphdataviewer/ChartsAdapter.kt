package com.deerbrain.graphdataviewer

import android.content.Context
import android.graphics.Color
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deerbrain.graphdataviewer.Utill.Callback
import com.deerbrain.graphdataviewer.Utill.ScreenResolutionForResult
import com.deerbrain.graphdataviewer.Utill.animatePieViewResolution
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo
import java.util.*
import kotlin.collections.ArrayList


class ChartsAdapter(val cellsToShow: List<GraphRecyclerItem>, val context: Context,val callback: Callback) :
    RecyclerView.Adapter<ChartsAdapter.GraphCellHolder>() {
    val CHARTONE: Int = 0
    val CHARTTWO: Int = 1
    val PIECHART: Int = 2


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GraphCellHolder {
        var cellItem: View? = null
        when (viewType) {

            CHARTONE -> {
                cellItem =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.graphviewcell_chart, parent, false)
            }
            CHARTTWO -> {
                cellItem =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.graphviewcell_chart, parent, false)
            }
            PIECHART -> {
                cellItem =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.graphviewcell_pie, parent, false)
            }

        }



        return GraphCellHolder(cellItem!!)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return CHARTONE
        }
        if (position == 1) {
            return CHARTTWO
        }
        if (position == 2) {
            return PIECHART
        }
        return 0
    }

    override fun onBindViewHolder(holder: GraphCellHolder, position: Int) {
        val individualGraphCell = cellsToShow[position]
        holder.headerLabel.setText(individualGraphCell.theHeaderLabel)
        var label = ""

        if (CHARTONE == position) {
            label = "Hour of day"
        } else if (CHARTTWO == position) {
            label = "Moon Phase"

        }

        holder.moreBtn?.setOnClickListener(){
            callback.onComplete(position)

        }
        if (CHARTONE == position) {

            holder.barchart?.let {
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
                set1 = BarDataSet(yVals1, label)
                val dataSets = ArrayList<IBarDataSet>()
                dataSets.add(set1)

                val data = BarData(dataSets)


                set1.setColor(Color.WHITE)
                data.setDrawValues(false)

                data.setValueTextSize(10f)
                data.barWidth = .1f
                mChart.setData(data)
                mChart.getLegend().setEnabled(true)

            }

        }
        if (CHARTTWO == position) {

            holder.barchart?.let {
                var mChart: HorizontalBarChart = it
                val labels: ArrayList<String> = ArrayList()
                labels.add("0.0")
                labels.add("0.5")
                labels.add("1.0")
                labels.add("1.5")
                labels.add("2.0")
                labels.add("2.5")
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
                set1 = BarDataSet(yVals1, label)
                val dataSets = ArrayList<IBarDataSet>()
                dataSets.add(set1)

                val data = BarData(dataSets)


                set1.setColor(Color.WHITE)
                data.setDrawValues(false)

                data.setValueTextSize(10f)
                data.barWidth = .1f
                mChart.setData(data)
                mChart.getLegend().setEnabled(true)

            }

        }
        if (PIECHART == position) {
//            var pair = animatePieViewResolution(windowManager)
            val windowManager =
                context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

            // will adjust according to every screen
            val strokewidth: Int = ScreenResolutionForResult(windowManager)
            val pair: Pair<Int, Int> =
                animatePieViewResolution(windowManager)
            AnimateView(holder, strokewidth, pair)
        }

    }

    private fun AnimateView(holder: GraphCellHolder, strokewidth: Int, pair: Pair<Int, Int>) {

        var pieView = holder.barPieChart

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

    override fun getItemCount() = cellsToShow.size
    inner class GraphCellHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val headerLabel: TextView = itemView.findViewById(R.id.headerLabel)
        val barchart: HorizontalBarChart? = itemView?.findViewById(R.id.barchart)
        val barPieChart: AnimatedPieView? = itemView?.findViewById(R.id.piechart)
        val moreBtn: Button? = itemView?.findViewById(R.id.moreButton)




    }


}