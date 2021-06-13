package com.deerbrain.graphdataviewer

import java.io.Serializable
import android.widget.Button

class GraphRecyclerItem (
    val theHeaderLabel: String
    //val data: TableCellData
    //var chartView: DeerChartView

//    fun updateUI(){
//        when (data.type) {
//            .hourOfDay -> {
//            headerlabel.text = data.title
//            chartView.setEntries(
//                data.data,
//                label: "Hour of Day", axisLabels: DeerChartView.hourlabel, yAxisMax: (data?.maxY))
//        }
//            .timeTillDusk -> {
//            headerlabel.text = data.title
//            chartView.setEntriesandLabel{
//                data.data, label: "Time Til Dusk"
//            }
//            val timeTillDuskLabel: Array<String> = arrayOf("4:00","3:45", "3:30", "3:15", "3:00","2:45","2:30", "2:15", "2:00", "1:45","1:30", "1:15", "1:00", "0:45","0:30", "0:15", "Sunset", "-0:15", "-0:30", "-0:45", "-1:00", "-1:15", "-1:30", "-1:45", "-2:00")
//
//            chartView.leftAxis.axisMaximum = data.maxY
//            chartView.scaleXenabled = false
//            chartView.xAxis.valueFormatter = IndexAxisValueFormatter(values: timeTillDuskLabel)
//        }
//
//
//        }
//    }


): Serializable