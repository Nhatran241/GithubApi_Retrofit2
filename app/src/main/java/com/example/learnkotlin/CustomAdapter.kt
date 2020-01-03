package com.example.learnkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnkotlin.Data.Repo
import kotlinx.android.synthetic.main.item.view.*

class CustomAdapter(private val dataset: Array<Repo>):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    class ViewHolder(val viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false) as ViewGroup
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewGroup.tv.setText(dataset[position].name)
    }

}