package com.deerbrain.graphdataviewer.Charts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deerbrain.graphdataviewer.R

//This activity will be reached when More Button is pressed.

// the activity will have a multiple segment controllers at the top and have a graph in the middle

//when a segment controller is changed it will change the graph data.
class BaseGraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_graph)
    }
}