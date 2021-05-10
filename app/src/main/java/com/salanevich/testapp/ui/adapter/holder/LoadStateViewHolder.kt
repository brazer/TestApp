package com.salanevich.testapp.ui.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.salanevich.testapp.R
import com.salanevich.testapp.databinding.LoadStateItemBinding

class LoadStateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.load_state_item, parent, false)
) {

    private val binding = LoadStateItemBinding.bind(itemView)
    private val progressBar: ProgressBar = binding.progressBar
    private val errorMessage: TextView = binding.errorMessage

    fun bind(state: LoadState) {
        if (state is LoadState.Error) {
            errorMessage.text = state.error.localizedMessage
        }
        progressBar.isVisible = state is LoadState.Loading
        errorMessage.isVisible = state is LoadState.Error
    }

}