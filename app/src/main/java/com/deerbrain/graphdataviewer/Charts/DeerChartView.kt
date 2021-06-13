package com.deerbrain.graphdataviewer.Charts


// this will extend the LineChartView to create a easier way to handle and change the data.
class DeerChartView {
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
////     }
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
//    static let beforeDawnLabels = [ "-2:00", "-1:45", "-1:30", "-1:15", "-1:00", "-0:45", "-0:30", "-0:15", "Sunrise", "0:15", "0:30", "0:45", "0:15", "1:00", "1:15", "1:30", "1:45", "2:00", "2:15", "2:30", "2:45", "3:00", "3:15", "3:30", "3:45", "4:00", "4:15", "4:30", "4:45", "5:00"]
//    static let timeTillDuskLabel = [ "4:00", "3:45", "3:30", "3:15", "3:00","2:45","2:30", "2:15", "2:00", "1:45","1:30", "1:15", "1:00", "0:45","0:30", "0:15", "Sunset", "-0:15", "-0:30", "-0:45", "-1:00", "-1:15", "-1:30", "-1:45", "-2:00"]
//    static let moonPhaseLabel = ["New","Waxing Crescent", "Waxing Crescent", "Waxing Crescent", "Waxing Crescent","Waxing Crescent","1st Quarter", "1st Quarter", "Waxing Gibbous", "Waxing Gibbous", "Waxing Gibbous", "Waxing Gibbous", "Waxing Gibbous", "Full", "Full", "Full", "Waning Gibbous", "Waning Gibbous", "Waning Gibbous", "Waning Gibbous", "Waning Gibbous", "Last Quarter", "Last Quarter", "Waning Crescent", "Waning Crescent", "Waning Crescent", "Waning Crescent", "Waning Crescent", "Waning Crescent"]
//    static let hourLabel = ["0:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00"]
//
//
//    static let moonPhaseText = "The Moon Phase Text goes here"
//}