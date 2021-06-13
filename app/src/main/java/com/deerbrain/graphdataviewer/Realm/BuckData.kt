package com.deerbrain.graphdataviewer.Realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class BuckData: RealmObject() {
    @PrimaryKey var id: Int = 0
    var buckTag: String = ""
    var theLat: Double = 0.0
    var theLong: Double = 0.0
    var cameraLocationName: String = ""
    var photoDateString: String = ""
    var UID: String = UUID.randomUUID().toString()





}