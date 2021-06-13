package com.deerbrain.graphdataviewer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deerbrain.graphdataviewer.Charts.BaseGraphActivity
import com.deerbrain.graphdataviewer.Charts.SampleDataMaker
import com.deerbrain.graphdataviewer.Realm.TagDataRealmManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {

        lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        //TagDataRealmManager.setup()  // with this working the data will populate

        openGraphsButton.setOnClickListener {
            openGraphsButtonPressed()
        }
    }

    fun openGraphsButtonPressed(){
        val intent = Intent(this, DataRecyclerActivity::class.java)
        startActivity(intent)
        TagDataRealmManager.setup()
    }
}
