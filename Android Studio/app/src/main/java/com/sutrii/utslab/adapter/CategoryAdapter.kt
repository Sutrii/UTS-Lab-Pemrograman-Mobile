package com.sutrii.utslab.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sutrii.utslab.R
import com.sutrii.utslab.data.DataCategory

class CategoryAdapter(private val categories: List<DataCategory>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage: ImageView = itemView.findViewById(R.id.category_image)
        val categoryName: TextView = itemView.findViewById(R.id.category_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context: Context = parent.context
        val inflater: LayoutInflater = LayoutInflater.from(context)

        val itemView: View = inflater.inflate(R.layout.layout_category, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category: DataCategory = categories[position]

        // Set data for each item in the RecyclerView
        holder.categoryImage.setImageResource(category.imageResource)
        holder.categoryName.text = category.name
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}