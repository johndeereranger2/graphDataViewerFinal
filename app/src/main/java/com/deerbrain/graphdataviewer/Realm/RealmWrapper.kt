package com.deerbrain.graphdataviewer.Realm


import android.content.Context
import com.deerbrain.graphdataviewer.MainActivity
import io.realm.*

object RealmWrapper {
    private var iRealm: Realm? = null

    val realm: Realm

        get() {

            if (iRealm == null) {

                RealmManager.initalize(MainActivity.context)

                iRealm = RealmManager.getRealm("myRealm", 4) { schema, version ->

                    if (version == 4L) return@getRealm

                    val dish = schema.get("Dish") ?: schema.create("Dish")

                    dish.addField("id", Int::class.java, FieldAttribute.PRIMARY_KEY)
                            .addField("name", String::class.java, FieldAttribute.REQUIRED)
                            .addField("price", Float::class.java)
                }
            }

            return iRealm!!
        }
}