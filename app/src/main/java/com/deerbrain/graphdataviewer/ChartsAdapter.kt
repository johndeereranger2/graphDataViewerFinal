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
import com.deerbrain.graphdataviewer.Charts.DeerChartView
import com.deerbrain.graphdataviewer.Charts.DeerPieChartView
import com.deerbrain.graphdataviewer.DeerChartCalcs.Companion.hourOfDayData
import com.deerbrain.graphdataviewer.DeerChartCalcs.Companion.sightingsPerCam
import com.deerbrain.graphdataviewer.DeerChartCalcs.Companion.timeSince6AM
import com.deerbrain.graphdataviewer.Utill.Callback
import com.deerbrain.graphdataviewer.Utill.ScreenResolutionForResult
import com.deerbrain.graphdataviewer.Utill.animatePieViewResolution
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.charts.LineChart
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


class ChartsAdapter(
    val cellsToShow: List<GraphRecyclerItem>,
    val context: Context,
    val callback: Callback
) :
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

        holder.moreBtn?.setOnClickListener() {
            callback.onComplete(position)

        }
        if (CHARTONE == position) {

            holder.barchart?.let {
                val chartview = DeerChartView(context, it)
                chartview.setValues(hourOfDayData())
            }

        }
        if (CHARTTWO == position) {

            holder.barchart?.let {
                var chartview = DeerChartView(context, it)
                chartview.setValues(timeSince6AM())


            }

        }
        if (PIECHART == position) {
            holder.barPieChart.let {
                var pieView = DeerPieChartView(it!!)
                pieView?.setValueForPieView(context,sightingsPerCam())
            }

        }

    }


    override fun getItemCount() = cellsToShow.size
    inner class GraphCellHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val headerLabel: TextView = itemView.findViewById(R.id.headerLabel)
        var barchart: LineChart? = itemView?.findViewById(R.id.barchart)
        val barPieChart: AnimatedPieView? = itemView?.findViewById(R.id.piechart)
        val moreBtn: Button? = itemView?.findViewById(R.id.moreButton)


    }


}