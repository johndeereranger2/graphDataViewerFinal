package com.deerbrain.graphdataviewer

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.graphviewcell_chart.view.*

class GraphCell(graphCellView: View): RecyclerView.ViewHolder(graphCellView) {
    val headerLabel: TextView = graphCellView.headerLabel
    val moreButton: Button = graphCellView.moreButton
    //val chartView: DeerChartView = graphCellView.baseChartView

}