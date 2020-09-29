package com.example.dagger_two_terminal_commands.adapters

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dagger_two_terminal_commands.R
import com.example.dagger_two_terminal_commands.models.CategoriesModel

class CategoriesAdapter constructor(
     val context: Context,
     val list: List<CategoriesModel?>,
     val adapterOnClick: AdapterOnClick
) : RecyclerView.Adapter<CategoriesAdapter.Definations>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Definations {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.recyclerview_categories_layout, parent, false)
        return Definations(view)
    }

    override fun onBindViewHolder(holder: Definations, position: Int) {
        holder.categoryName.setText(list!![position]?.title)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }


    inner class Definations(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView

        init {
            categoryName =
                itemView.findViewById(R.id.recyclerview_categories_layout_category_textView)
            itemView.setOnClickListener { adapterOnClick.onClick(getAdapterPosition()) }
        }
    }
}