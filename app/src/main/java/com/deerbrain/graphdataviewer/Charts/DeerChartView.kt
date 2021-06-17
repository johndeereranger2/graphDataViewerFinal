package com.deerbrain.graphdataviewer.Charts

import android.content.Context
import android.os.Build
import androidx.core.content.ContextCompat
import com.deerbrain.graphdataviewer.R
import com.deerbrain.graphdataviewer.Utill.CustomMarker
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter


// this will extend the LineChartView to create a easier way to handle and change the data.

class DeerChartView(context: Context?, barchart: LineChart) : LineChart(context) {
    private var barchart: LineChart = barchart
    private var dataSet: LineDataSet? = null


    fun setValues(entries: ArrayList<Entry>) {
        val lineChart = barchart

        with(lineChart) {
            // (1)

//Part3
            dataSet = LineDataSet(entries, "2021-06-13")
//Part4
            dataSet?.setDrawValues(false)
            dataSet?.setDrawCircles(false)
            dataSet?.setDrawFilled(false)

            dataSet?.lineWidth = 4f
            dataSet?.fillColor = R.color.theme_color
            dataSet?.fillAlpha = R.color.black
            dataSet?.color = ContextCompat.getColor(context, R.color.white)
            dataSet?.mode = LineDataSet.Mode.CUBIC_BEZIER


            val xAxis = lineChart.xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM


//Part5
            lineChart.xAxis.labelRotationAngle = 0f
//Part6
            lineChart.data = LineData(dataSet)
//Part7
            lineChart.axisRight.isEnabled = false
//Part8
            lineChart.setTouchEnabled(true)
            lineChart.setPinchZoom(true)
//Part9
            lineChart.description.text = "Days"
            lineChart.setGridBackgroundColor(R.color.theme_color)
//Part10
            lineChart.animateX(1000, Easing.EaseInExpo)
            val colors = intArrayOf(
                resources.getColor(R.color.theme_color),
                resources.getColor(android.R.color.white)
            )
            setupBackground()


//Part11
            val markerView = CustomMarker(context, R.layout.laychart)
            lineChart.marker = markerView
            lineChart.invalidate()
        }


    }

    fun setupBackground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            dataSet?.setDrawFilled(true)
            val fillGradient = ContextCompat.getDrawable(context, R.drawable.gradient_line_chart)
            dataSet?.fillDrawable = fillGradient
        }
    }

    private fun getDataSet(): ArrayList<Entry>? {
        val lineEntries: ArrayList<Entry> =
            ArrayList()
        lineEntries.add(Entry(0f, 4f))
        lineEntries.add(Entry(1f, 3f))
        lineEntries.add(Entry(2f, 4f))
        lineEntries.add(Entry(3f, 5f))
        lineEntries.add(Entry(4f, 6f))
        lineEntries.add(Entry(5f, 3f))
        lineEntries.add(Entry(6f, 7f))
        return lineEntries
    }


}

// this is the iOS Class
//class DeerChartView: LineChartView {
//  var entries: [ChartDataEntry] = [] { didSet {
//    let set = LineChartDataSet(entries: entries, label: "TESTER")
//    //let set = LineChartDataSet(entries: entries)
//    set.colors = ChartColorTemplates.joyful()
//    set.drawCirclesEnabled = false
//    set.mode = .cubicBezier
//    set.lineWidth = 3
//    set.setColor(.white)
//    set.fillColor = .white
//    set.fillAlpha = 0.8
//    set.drawFilledEnabled = true
//    set.drawHorizontalHighlightIndicatorEnabled = false
//    set.highlightColor = .systemRed
//    let data = LineChartData(dataSet: set)
//    data.setDrawValues(false)
//    self.data = data
//    setupBackground()
//    }}
//  static var data: ChartData?
//
//
//    func setupBackground() {
//
//        self.backgroundColor = UIColor(red: 112/255, green: 179/255, blue: 110/255, alpha: 1)
//        self.rightAxis.enabled = false
//
//        let yAxis = self.leftAxis
//        yAxis.labelFont = .boldSystemFont(ofSize: 12)
//        yAxis.setLabelCount(6, force: false)
//        yAxis.labelTextColor = .white
//        yAxis.axisLineColor = .white
//        yAxis.labelPosition = .outsideChart
//
//        self.xAxis.labelPosition = .bottom
//        self.xAxis.labelFont = .boldSystemFont(ofSize: 12)
//        self.xAxis.labelTextColor = .white
//        self.xAxis.axisLineColor = .systemBlue
//
//        self.animate(xAxisDuration: 1.0)
//    }
//
//  override func awakeFromNib() {
//    super.awakeFromNib()
//
//    //let chartView = LineChartView()
//    self.backgroundColor = UIColor(red: 112/255, green: 179/255, blue: 110/255, alpha: 1)
//    self.rightAxis.enabled = false
//
//    let yAxis = self.leftAxis
//    yAxis.labelFont = .boldSystemFont(ofSize: 12)
//    yAxis.setLabelCount(6, force: false)
//    yAxis.labelTextColor = .white
//    yAxis.axisLineColor = .white
//    yAxis.labelPosition = .outsideChart
//
//    self.xAxis.labelPosition = .bottom
//    self.xAxis.labelFont = .boldSystemFont(ofSize: 12)
//    self.xAxis.labelTextColor = .white
//    self.xAxis.axisLineColor = .systemBlue
//
//    self.animate(xAxisDuration: 2.5)
//    //var entries: [BarChartDataEntry]?
////    var entries = [BarChartDataEntry]()
////
////     for x in 0..<10 {
////       entries.append(BarChartDataEntry(x: Double(x),y:Double(x)))
////     }x
//    self.roundCorners(to: 15)
//
//  }
//
//  var deerData = [DeerMovement]()
//
//
//
//  func calcDeer(){
//    deerData.append(DeerMovement(deerID: 1, moveCount: 2, moveTime: Date()))
//  }
//
//}
//
//struct DeerMovement {
//  let deerID: Int
//  let moveCount: Int
//  let moveTime: Date
//}
//
//
//
//extension DeerChartView {
//    func setEntries(_ entries: [ChartDataEntry], label: String, axisLabels: [String], yAxisMax: Double) {
//
//        self.setEntriesAndLabel(entries: entries, label: label)
//        let localYMax = (entries.maxY * 2)
//        leftAxis.resetCustomAxisMax()
//        if localYMax < yAxisMax {
//            leftAxis.axisMaximum  = (yAxisMax / 2)
//        } else {
//            leftAxis.axisMaximum = yAxisMax
//        }
//
//        xAxis.valueFormatter = IndexAxisValueFormatter(values: axisLabels)
//        self.scaleYEnabled = false
//        self.scaleXEnabled = true
//        self.setNeedsLayout()
//        self.layoutSubviews()
//    }
//
//    func setEntriesAndLabel(entries: [ChartDataEntry], label: String ){
//        let set = LineChartDataSet(entries: entries, label: label)
//        //let set = LineChartDataSet(entries: entries)
//        set.colors = ChartColorTemplates.joyful()
//        set.drawCirclesEnabled = false
//        set.mode = .cubicBezier
//        set.lineWidth = 3
//        set.setColor(.white)
//        set.fillColor = .white
//        set.fillAlpha = 0.8
//        set.drawFilledEnabled = true
//        set.drawHorizontalHighlightIndicatorEnabled = false
//        set.highlightColor = .systemRed
//        let data = LineChartData(dataSet: set)
//        data.setDrawValues(false)
//        self.data = data
//        setupBackground()
//    }
//
var beforeDawnLabels = arrayListOf<String>(
    "-2:00",
    "-1:45",
    "-1:30",
    "-1:15",
    "-1:00",
    "-0:45",
    "-0:30",
    "-0:15",
    "Sunrise",
    "0:15",
    "0:30",
    "0:45",
    "0:15",
    "1:00",
    "1:15",
    "1:30",
    "1:45",
    "2:00",
    "2:15",
    "2:30",
    "2:45",
    "3:00",
    "3:15",
    "3:30",
    "3:45",
    "4:00",
    "4:15",
    "4:30",
    "4:45",
    "5:00"
)
var timeTillDuskLabel = arrayListOf<String>(
    "4:00",
    "3:45",
    "3:30",
    "3:15",
    "3:00",
    "2:45",
    "2:30",
    "2:15",
    "2:00",
    "1:45",
    "1:30",
    "1:15",
    "1:00",
    "0:45",
    "0:30",
    "0:15",
    "Sunset",
    "-0:15",
    "-0:30",
    "-0:45",
    "-1:00",
    "-1:15",
    "-1:30",
    "-1:45",
    "-2:00"
)
var moonPhaseLabel = arrayListOf<String>(
    "New",
    "Waxing Crescent",
    "Waxing Crescent",
    "Waxing Crescent",
    "Waxing Crescent",
    "Waxing Crescent",
    "1st Quarter",
    "1st Quarter",
    "Waxing Gibbous",
    "Waxing Gibbous",
    "Waxing Gibbous",
    "Waxing Gibbous",
    "Waxing Gibbous",
    "Full",
    "Full",
    "Full",
    "Waning Gibbous",
    "Waning Gibbous",
    "Waning Gibbous",
    "Waning Gibbous",
    "Waning Gibbous",
    "Last Quarter",
    "Last Quarter",
    "Waning Crescent",
    "Waning Crescent",
    "Waning Crescent",
    "Waning Crescent",
    "Waning Crescent",
    "Waning Crescent"
)
var hourLabel = arrayListOf<String>(
    "0:00",
    "1:00",
    "2:00",
    "3:00",
    "4:00",
    "5:00",
    "6:00",
    "7:00",
    "8:00",
    "9:00",
    "10:00",
    "11:00",
    "12:00",
    "13:00",
    "14:00",
    "15:00",
    "16:00",
    "17:00",
    "18:00",
    "19:00",
    "20:00",
    "21:00",
    "22:00",
    "23:00",
    "24:00"
)
//
//
//    static let moonPhaseText = "The Moon Phase Text goes here"
//}