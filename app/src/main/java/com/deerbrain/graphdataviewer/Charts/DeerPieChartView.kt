package com.deerbrain.graphdataviewer.Charts

class DeerPieChartView {
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
