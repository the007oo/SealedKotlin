package com.phattarapong.sealedapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataList: MutableList<Model> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Model.ModelType.TYPE_HEADER.ordinal -> {
                HeaderViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                )
            }
            Model.ModelType.TYPE_BODY.ordinal -> {
                BodyViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_body, parent, false)
                )
            }
            Model.ModelType.TYPE_FOOTER.ordinal -> {
                FooterViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_footer, parent, false)
                )
            }
            else -> throw Exception("View type $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int = dataList[position].type.ordinal

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        when (holder) {
            is HeaderViewHolder -> {
                val header = data as Model.Header
                holder.textView.text = header.header
            }
            is BodyViewHolder -> {
                val body = data as Model.Body
                holder.textView.text = body.text
            }
            is FooterViewHolder -> {
                val footer = data as Model.Footer
                holder.textView.text = footer.text
            }
        }
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }

    class BodyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }

    class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }
}