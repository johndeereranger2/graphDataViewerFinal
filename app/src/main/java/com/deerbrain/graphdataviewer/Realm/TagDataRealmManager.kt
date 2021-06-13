package com.deerbrain.graphdataviewer.Realm

import android.util.Log
import com.deerbrain.graphdataviewer.Charts.SampleDataMaker
import com.deerbrain.graphdataviewer.Charts.TimDataStruct


object TagDataRealmManager {
    
    var allBuckData: List<BuckData> = emptyList()

    fun setup(){
        val newBuckData = allData()
        if (newBuckData != null) {
            allBuckData = newBuckData
        } else {
            SampleDataMaker.createData()
            addArrayData(SampleDataMaker.dataArray)
        }
    }



    fun addArrayData(timArray: ArrayList<TimDataStruct>) {


        for (item in timArray) {
            var id = (RealmWrapper.realm.where(BuckData::class.java).max("id")?.toInt() ?: 0) + 1
            val newItem = BuckData()
            newItem.id = id
            newItem.cameraLocationName = item.locationName
            newItem.buckTag = item.name
            newItem.photoDateString = item.photoDate


            RealmWrapper.realm.executeTransaction{
                it.insert(newItem)
            }
            Log.i("Realm", "Stored Marker at ${id} ${item.photoDate}")
        }


    }
//
//    fun buckData(named: String) : Results<BuckData>? {
//        return RealmWrapper.realm.objects<BuckData>().query("buckTag = $0", named)
//    }
//
////      func buckData(named: String) -> Results<BuckData>?{
////         let passedRealm = RealmWrapper.instance.createRealm()
////         return passedRealm.objects(BuckData.self).filter("buckTag == %@", named)
////     }
//
//    func filteredBuckData(named: String, am: amOrPm, day: dayOrNight) -> Results<BuckData>? {
//        var filter = realm.objects(BuckData.self).filter("buckTag == %@", named)
//
//
//        switch am {
//        case .am:
//            filter = filter.filter("amOrPM == %@", "AM")
//
//        case .pm:
//            filter = filter.filter("amOrPM == %@", "PM")
//        case .all:
//            print("do nothing")
//        }
//
//        switch day {
//        case .daylight:
//            filter = filter.filter("isDaylight == %@", true)
//
//        case .night:
//            filter = filter.filter("isDaylight == %@", false)
//        case .all:
//            print("do nothing")
//        }
//
//        return filter
//    }
//
//    fun buckDataUiD(UID: String) : Results<BuckData> {
//         return RealmWrapper.realm.objects<BuckData>().query("buckUUID = $0", UID)
//    }
//
////     func buckDataUiD(_ UID: String) -> Results<BuckData>?{
////         return realm.objects(BuckData.self).filter("buckUUID == %@", UID)
////     }
//
//
//    func buckData(buck: BuckList, UIDD: String) -> Results<BuckData>?{
//        return buck.buckData.filter("counter > %@", 0)
//    }
//
    fun allData() : List<BuckData>? {
        return RealmWrapper.realm.where(BuckData::class.java).findAll()
    }
//
////     func allData() -> Results<BuckData>?{
////         let otherRealm = RealmWrapper.instance.createRealm()
////         listOfBuckData = otherRealm.objects(BuckData.self)
////         return listOfBuckData
////     }
//
//    fun getAllData(): ArrayList<BuckData> {
//        val listOfBuckData = RealmWrapper.realm.objects<BuckData>()
//        var arrayOfBuckData: = ArrayList<BuckData> = ArrayList<BuckData>()
//        for buck in listOfBuckData{
//            arrayOfBuckData.add(buck)
//        }
//
//        return arrayOfBuckData
//    }
//
////     func getAllData() -> [BuckData]{
////         let listOfBuckData = realm.objects(BuckData.self)
////         var arrayOfBuckData: [BuckData] = []
////         for buck in listOfBuckData{
////             arrayOfBuckData.append(buck)
////         }
////         return arrayOfBuckData
//
////     }
//
//    func lastSeen(_ name: String) -> String {
//        //TODO: This really should be done when data is stored and check if the date is newer and if it is write the exact time of the last data point.
//        if let maxBlock =  realm.objects(BuckData.self).filter("buckTag == %@" , name).max(ofProperty: "timeBlock") as Int? {
//
//            let date = Date(timeIntervalSince1970: Double(maxBlock * 900))
//            let stringDF = DateFormatter()
//            stringDF.dateFormat = "MM-dd-yyyy h:mm a"
//            return stringDF.string(from: date)
//
//        } else {
//            return "No Date"
//        }
//
//
//    }
//
//    func countOfData(_ name: String) -> Int {
//        if let data = buckData(named: name) {
//            return data.count
//        }
//        return 0
//    }
//
//    func getAllBuckData() -> [BuckData] {
//        var arrayOfData: [BuckData] = []
//        if let data = allData(){
//            for buck in data {
//                if buck.buckTag != "Sample Data" {
//                    arrayOfData.append(buck)
//                }
//            }
//        }
//        print(#function, "count of data is:", arrayOfData.count)
//        return arrayOfData
//    }
//
//    fun getOneBuckData(name: String) : ArrayList<BuckData> {
//        var arrayOfData: ArrayList<BuckData>()
//        val rawData = buckData(named: name)
//        if (rawData != null) {
//         for (buck in rawData) {
//            arrayOfData.add(buck)
//         }
//
//        }
//
//        return arrayOfData
//
//    }
//
////     func getOneBuckData(_ name: String) -> [BuckData] {
//
////         var arrayOfData: [BuckData] = []
////         if let data = buckData(named: name) {
////             for buck in data {
////                 arrayOfData.append(buck)
////             }
////         }
////         printOneBuckData(name)
////         print(#function, "count of data is:", arrayOfData.count)
////         return arrayOfData
////     }
//
//    func deleteOneBuckData(){
//        let bucks = realm.objects(BuckData.self).filter("buckTag == %@", "Sample Data")
//        do {
//            try realm.write{
//                realm.delete(bucks)
//            }
//        } catch {
//            print("error deleting sample datea")
//        }
//    }
//
//    func printOneBuckData(_ name: String) {
//        CameraRealmManager.instance.printCamList()
//        let storedName = "Sample Data"
//        if let data = buckData(named: name) {
//            var counter = 0
//            for buck in data {
//                //if counter < 20 {
//                //print("Insert perfect format string here that will be copied into new file")
//                //set up camera locations
//                    print("dataArray.append(TimDataStruct(name: \"\(storedName)\", photoDate: \"\(String(describing: buck.pictureDate!))\", locationName: \"\(buck.cameraLocationName)\"))")
//                    counter += 1
//               // }
//            }
//        }
//    }
//
//    func getOneBuckMonthData(_ name: String, month: Int) -> [BuckData] {
//        var arrayOfData: [BuckData] = []
//        if let data = buckData(named: name) {
//            for buck in data {
//                if buck.pictureDate?.month.rawValue == month {
//                    arrayOfData.append(buck)
//                }
//            }
//        }
//        print(#function, "count of data is:", arrayOfData.count)
//        return arrayOfData
//    }
//
//    func getFallBuckData(_ name: String) -> [BuckData] {
//        var arrayOfData: [BuckData] = []
//        if let data = buckData(named: name) {
//            for buck in data {
//                let mon = buck.pictureDate?.month.rawValue
//                if mon == 9 || mon == 10 || mon == 11 || mon == 12 {
//                    arrayOfData.append(buck)
//                }
//            }
//        }
//        print(#function, "count of data is:", arrayOfData.count)
//        return arrayOfData
//    }
//
//    func getData(_ name: String, month: [Int], dayOrNight: dayOrNight = .all, am: amOrPm = .all) -> [BuckData] {
//        var arrayOfData: [BuckData] = []
//        //filter by month
//        if let data = buckData(named: name) {
//            for buck in data {
//                if let mon = buck.pictureDate?.month.rawValue {
//                    if month.contains(mon) {
//                        arrayOfData.append(buck)
//                    }
//                }
//            }
//        }
//        print(#function, "count of data is:", arrayOfData.count)
//        return arrayOfData
//    }
//
//    func getMonthBuckData(_ named: String, month: Int ) -> Results<BuckData>? {
//               return realm.objects(BuckData.self).filter("buckTag == %@", named)
//
//    }
//
//    func isBuckAlreadySavedAtTime(name: String, date: Date) -> Bool{
//        let dataOfBuck = realm.objects(BuckData.self).filter("buckTag == %@ && pictureDate == %@", name, date)
//        if dataOfBuck.count > 0 {
//            return true
//        }
//        return false
//    }
//
//    func urlAndCamNameOf(buck: String,at date: Date) -> (String? , String?) {
//        let dataOfBuck = realm.objects(BuckData.self).filter("buckTag == %@ && pictureDate == %@", buck, date).first
//        var returnURL = ""
//        if let url = dataOfBuck?.urlString{
//            returnURL = url
//
//        }
//        var camLocation = ""
//             if let camLoc = dataOfBuck?.cameraLocationName{
//                 camLocation = camLoc
//
//             }
//
//        return (returnURL, camLocation)
//
//
//    }
//
//    func saveDate(date: Date) -> Date?{
//
//
//        let formatter = DateFormatter()
//        formatter.dateFormat = "mm"
//        guard let minute = Int(formatter.string(from: date)) else {return nil }
//        var returnMinutes: Int = 0
//        if minute < 15 {
//            returnMinutes = 0
//        } else if minute < 30 {
//            returnMinutes = 15
//        } else if minute < 45 {
//            returnMinutes = 30
//        } else if minute < 61{
//            returnMinutes = 45
//        }
//        print("getDay and hour", getDayAndHour(date: date), date)
//
//
//        let valueReturn = "\(getDayAndHour(date: date)):\(returnMinutes):00 +0000"
//        let dateFormatter = DateFormatter()
//        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ssZZZZZ"
//        let returnDate = dateFormatter.date(from: valueReturn)!
//        return returnDate
//    }
//
//    func getDayAndHour(date: Date) -> String{
//
//        let formatter = DateFormatter()
//        formatter.dateFormat = "yyyy-MM-dd HH"
//        //formatter.timeZone = TimeZone(abbreviation: "UTC")
//        return formatter.string(from: date)
//    }
//
//
//
//    func checkNewData(input: [BuckData]){
//        for buck in input {
//            let formatter = DateFormatter()
//            formatter.dateFormat = "a"
//            print("AM or PM \(formatter.string(from: buck.pictureDate!))")
//            print("count", buck.data.sunAzimuth as Any)
//            print(buck.computedData.amOrPM as Any)
//        }

}
