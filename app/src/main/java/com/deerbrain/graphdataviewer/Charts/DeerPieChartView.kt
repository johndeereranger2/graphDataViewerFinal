package com.deerbrain.graphdataviewer.Charts

import android.content.Context
import android.graphics.Color
import android.util.Pair
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import com.deerbrain.graphdataviewer.MainActivity.Companion.context
import com.deerbrain.graphdataviewer.Utill.ScreenResolutionForResult
import com.deerbrain.graphdataviewer.Utill.animatePieViewResolution
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.PieEntry
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo
import java.util.*
import kotlin.collections.ArrayList

class DeerPieChartView(pieView: AnimatedPieView) {

    private var pie: AnimatedPieView = pieView

    fun setValueForPieView(context: Context, list: ArrayList<SimplePieInfo>) {
        val windowManager =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        // will adjust according to every screen
        val strokewidth: Int = ScreenResolutionForResult(windowManager)
        val pair: Pair<Int, Int> =
            animatePieViewResolution(windowManager)
        var pieView = pie

        val time = floatArrayOf(55f, 95f, 30f, 360 - (55 + 95 + 30).toFloat())
        val activity =
            arrayOf("Jan", "Feb", "March", "")
        val pieEntires: MutableList<PieEntry> = ArrayList()
        for (i in 0 until time.size) {
            pieEntires.add(PieEntry(time[i], activity[i]))
        }
        val config = AnimatedPieViewConfig()
        for (data in list){
            config.addData(data)
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
}


//ios class is below

////
//class DeerPieChartView: PieChartView {
//    var entries: [PieChartDataEntry] = [] { didSet {
//        let set = PieChartDataSet(entries: entries)
//        set.colors = ChartColorTemplates.material()
//        set.drawValuesEnabled = false
////        set.drawFilledEnabled = true
////        set.drawHorizontalHighlightIndicatorEnabled = false
//        set.highlightColor = .systemRed
//
//                let data = PieChartData(dataSet: set)
//        data.setDrawValues(false)
//        self.data = data
//
//    }}
//    static var data: ChartData?
//
//    func setEntriesAndLabel(entries: [PieChartDataEntry], title: String){
//        let set = PieChartDataSet(entries: entries, label: title)
//
//        set.colors = ChartColorTemplates.material()
//        set.drawValuesEnabled = false
//        set.highlightColor = .systemRed
//                self.drawHoleEnabled = false
//        let data = PieChartData(dataSet: set)
//        data.setDrawValues(false)
//        self.data = data
//
//    }
//
//
//    override func awakeFromNib() {
//        super.awakeFromNib()
//        self.roundCorners(to: 15)
//        self.chartDescription?.enabled = false
//        self.drawHoleEnabled = false
//        self.rotationAngle = 0
//        self.isUserInteractionEnabled = false
//        self.backgroundColor = UIColor(red: 112/255, green: 179/255, blue: 110/255, alpha: 1)
//        self.animate(xAxisDuration: 1.5)
//
//
//
//    }
//}
//
//class DeerBubbleChartView: BubbleChartView {
//    //let instance = DeerChartView()
//    var entries: [BubbleChartDataEntry] = [] { didSet {
//        let set = BubbleChartDataSet(entries: entries)
//        set.colors = ChartColorTemplates.material()
//        set.drawValuesEnabled = false
//        set.highlightColor = .systemRed
//
//                let data = BubbleChartData(dataSet: set)
//        data.setDrawValues(false)
//        self.data = data
//
//    }}
//    static var data: ChartData?
//
//
//    override func awakeFromNib() {
//        super.awakeFromNib()
//        self.chartDescription?.enabled = false
//        self.isUserInteractionEnabled = false
//        self.backgroundColor = .systemBlue
//                self.animate(xAxisDuration: 1.5)
//
//
//
//    }
//}
