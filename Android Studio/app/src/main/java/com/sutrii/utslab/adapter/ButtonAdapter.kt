package com.sutrii.utslab.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sutrii.utslab.R
import com.sutrii.utslab.data.DataButton

class ButtonAdapter(private val items: List<DataButton>, private val onItemClick: (DataButton) -> Unit) :
    RecyclerView.Adapter<ButtonAdapter.ViewHolder>() {

    var selectedPosition = RecyclerView.NO_POSITION
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val selectButton: Button = itemView.findViewById(R.id.select_button)

        init {
            selectButton.setOnClickListener {
//                val selectedItem = items[adapterPosition]
//                selectedItem.isSelected = !selectedItem.isSelected
//                onItemClick(selectedItem)
//                notifyItemChanged(adapterPosition)
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    val selectedItem = items[position]
                    selectedItem.isSelected = !selectedItem.isSelected

                    if (selectedPosition != RecyclerView.NO_POSITION){
                        items[selectedPosition].isSelected = false
                        notifyItemChanged(selectedPosition)
                    }

                    selectedPosition = position
                    notifyItemChanged(selectedPosition)

                    onItemClick(selectedItem)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context: Context = parent.context
        val inflater: LayoutInflater = LayoutInflater.from(context)

        val itemView: View = inflater.inflate(R.layout.layout_button, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: DataButton = items[position]

        // Set item-specific data (customize as needed)
        holder.selectButton.text = item.label
        val backgroundColor = if (item.isSelected) R.color.black else item.color
        val textcolor = if (item.isSelected) R.color.white else item.textcolor
        holder.selectButton.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, backgroundColor))
        holder.selectButton.setTextColor(ContextCompat.getColor(holder.itemView.context, textcolor))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}