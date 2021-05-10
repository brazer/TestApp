package com.salanevich.testapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.salanevich.testapp.R
import com.salanevich.testapp.databinding.ItemListContentBinding
import com.salanevich.testapp.ui.model.Item

class ItemRecyclerViewAdapter(
    private val onClickListener: View.OnClickListener,
    diffCallback: DiffUtil.ItemCallback<Item>
): PagingDataAdapter<Item, ItemRecyclerViewAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.imageView.load(item?.image?.url) {
            crossfade(true)
            allowHardware(false)
            placeholder(R.drawable.blurred_background)
        }
        holder.contentView.text = item?.name
        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    inner class ViewHolder(binding: ItemListContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imageHeader
        val contentView: TextView = binding.content
    }

}