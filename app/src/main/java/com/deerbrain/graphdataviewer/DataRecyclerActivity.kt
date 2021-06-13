package com.deerbrain.graphdataviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.deerbrain.graphdataviewer.Charts.DetailActivity
import com.deerbrain.graphdataviewer.Realm.BuckData
import com.deerbrain.graphdataviewer.Realm.TagDataRealmManager
import com.deerbrain.graphdataviewer.Utill.Callback
import kotlinx.android.synthetic.main.activity_data_recycler.*


//similar to DataTableViewController  inside DataViewer-> DataOverView
class DataRecyclerActivity : AppCompatActivity() {

    //activity needs to be updated to proper spacing
    //activity currently has buttons at the top and needs setup similar to iOS segmented Controller, not buttons


    var rawBuckData: List<BuckData> = emptyList()
    val dataSource = ChartAdapter()
    var displayData: Array<String> = arrayOf("Hour of Day","Time Till Dusk", "Trail Camera")
    var displayedGraphs: ArrayList<GraphRecyclerItem> = ArrayList<GraphRecyclerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_recycler)
        rawBuckData = TagDataRealmManager.allBuckData
        updateRecyclerView()
        setOnClicklisteners()
    }

    private fun setOnClicklisteners() {
        lay1?.setOnClickListener{
            lay1?.setBackgroundResource(R.drawable.bg_rect_select)
            lay2?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(0)




        }
        lay2?.setOnClickListener{
            lay2?.setBackgroundResource(R.drawable.bg_rect_select)
            lay1?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(0)

        }
        lay3?.setOnClickListener{

            lay2?.setBackgroundResource(0)
            lay1?.setBackgroundResource(0)
            lay3?.setBackgroundResource(R.drawable.bg_rect_select)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(0)
        }
        lay4?.setOnClickListener{
            lay1?.setBackgroundResource(0)
            lay2?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(R.drawable.bg_rect_select)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(0)

        }
        lay5?.setOnClickListener{
            lay1?.setBackgroundResource(0)
            lay2?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(R.drawable.bg_rect_select)
            lay6?.setBackgroundResource(0)

        }
        lay6?.setOnClickListener{
            lay1?.setBackgroundResource(0)
            lay2?.setBackgroundResource(0)
            lay3?.setBackgroundResource(0)
            lay4?.setBackgroundResource(0)
            lay5?.setBackgroundResource(0)
            lay6?.setBackgroundResource(R.drawable.bg_rect_select)

        }

    }

    fun updateRecyclerView() {
        updateDisplayedGraphs()
        // we need adapter for graphs that handle all type of card

        tableView?.layoutManager = LinearLayoutManager(this)
        val tableViewAdapter = ChartsAdapter(displayedGraphs,this, Callback {

            var intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("heading",displayedGraphs[it as Int].theHeaderLabel)
            intent.putExtra("pos",it.toString())
            startActivity(intent)


        })
        tableView?.adapter =  tableViewAdapter

    }

    fun updateDisplayedGraphs() {
        var graphOne = GraphRecyclerItem (
            theHeaderLabel = "Sighting by Hour of Day"
            // graphData = DeerChartCalcs.hourOfDayData(rawBuckData)
        )
        displayedGraphs.add(graphOne)

        var graphTwo = GraphRecyclerItem(
            theHeaderLabel = "Sighting by Moon Phase"
            //graphData = DeerChartCalcs.timeSince6AM(rawBuckData)
        )
        displayedGraphs.add(graphTwo)

        var graphThree = GraphRecyclerItem(
            theHeaderLabel = "Time Since Dawn"
            //graphData = DeerChartCalcs.sightingsPerCam(rawBuckData)
        )
        displayedGraphs.add(graphThree)
    }
}
