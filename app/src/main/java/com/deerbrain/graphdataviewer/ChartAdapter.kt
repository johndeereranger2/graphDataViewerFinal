package com.deerbrain.graphdataviewer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChartAdapter() : RecyclerView.Adapter<GraphCell>() {

    var cellsToShow = ArrayList<GraphRecyclerItem>()

    private var onClickListener: OnClickListener? = null

    ///numberOf rows
    override fun getItemCount(): Int {
        return cellsToShow.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GraphCell {
        val cellItem = LayoutInflater.from(parent.context).inflate(R.layout.graphviewcell_chart, parent, false)
        return GraphCell(cellItem)
    }

    fun setOnClickListener(itemPressed: OnClickListener) {
        this.onClickListener = itemPressed
    }

    interface OnClickListener {
        fun onClick(position: Int, model: GraphRecyclerItem)
    }

    override fun onBindViewHolder(holder: GraphCell, position: Int) {
        val individualGraphCell = cellsToShow[position]
        holder.headerLabel.text = individualGraphCell.theHeaderLabel


        //set up graphData
        //handle Morebutton onclicklistener

    }

    fun update(items: ArrayList<GraphRecyclerItem>) {
        this.cellsToShow.clear()
        this.cellsToShow = items
        notifyDataSetChanged()
    }

}



