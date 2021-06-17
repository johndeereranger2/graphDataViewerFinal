package com.deerbrain.graphdataviewer

import android.graphics.Color
import com.deerbrain.graphdataviewer.Realm.BuckData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieEntry
import com.razerdp.widget.animatedpieview.data.SimplePieInfo
import java.util.*
import kotlin.collections.ArrayList

class DeerChartCalcs {
    companion object {

        //this handles the calculations of taking a raw array of BuckData and providing the data in a way that is
        //easy to display the data for the charts.


        fun hourOfDayData(): ArrayList<Entry> {
            val entries = ArrayList<Entry>()
            entries.add(Entry(0f, 0f))
            entries.add(Entry(4f, 0f))
            entries.add(Entry(8f, 2.0f))
            entries.add(Entry(12f, 0f))
            entries.add(Entry(16f, 0f))
            entries.add(Entry(24f, 0f))
            return entries
        }

        //
        fun timeSince6AM(): ArrayList<Entry> {
            val labels: ArrayList<String> = ArrayList()
            labels.add("0.0")
            labels.add("0.5")
            labels.add("1.0")
            labels.add("1.5")
            labels.add("2.0")
            labels.add("2.5")
            val ylabels: ArrayList<String> = ArrayList()
            ylabels.add("New")
            ylabels.add("Full")
            ylabels.add("Full Moon")

            val entries = ArrayList<Entry>()
            entries.add(Entry(0f, 0f))
            entries.add(Entry(0.5f, 2f))
            entries.add(Entry(1.0f, 1.0f))
            return entries
        }

        //
        fun sightingsPerCam(): ArrayList<SimplePieInfo> {

            val pieEntires: ArrayList<SimplePieInfo> = ArrayList()
            val time = floatArrayOf(55f, 95f, 30f, 360 - (55 + 95 + 30).toFloat())

            for (info in time) {
                val rnd = Random()
                val color = Color.argb(
                    255,
                    rnd.nextInt(256),
                    rnd.nextInt(256),
                    rnd.nextInt(256)
                )
                pieEntires.add(SimplePieInfo(info.toDouble(), color, ""))
            }
            val activity =
                arrayOf("Jan", "Feb", "March", "")

            return pieEntires


        }
    }
}