package com.salanevich.testapp.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.salanevich.testapp.ui.model.Item

object ItemComparator: DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}