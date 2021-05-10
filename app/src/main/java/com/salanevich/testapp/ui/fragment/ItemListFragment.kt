package com.salanevich.testapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.salanevich.testapp.R
import com.salanevich.testapp.databinding.FragmentItemListBinding
import com.salanevich.testapp.ui.adapter.ItemComparator
import com.salanevich.testapp.ui.adapter.ItemLoadStateAdapter
import com.salanevich.testapp.ui.adapter.ItemRecyclerViewAdapter
import com.salanevich.testapp.ui.model.Item
import com.salanevich.testapp.vm.ItemViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private val errorMessage: TextView by lazy {
        binding.root.findViewById(R.id.errorMessage)
    }
    private val progressBar: ProgressBar by lazy {
        binding.root.findViewById(R.id.progressBar)
    }
    private val viewModel: ItemViewModel by viewModels()
    private lateinit var adapter: ItemRecyclerViewAdapter
    private var firstLoading = true

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.itemList
        val onClickListener = View.OnClickListener { itemView ->
            val item = itemView.tag as Item
            val bundle = Bundle()
            bundle.putString(
                ItemDetailFragment.ARG_ITEM_ID,
                item.id
            )
            itemView.findNavController().navigate(R.id.show_item_detail, bundle)
        }
        setupRecyclerView(recyclerView, onClickListener)
        lifecycleScope.launch {
            viewModel.flow.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
        progressBar.isVisible = firstLoading
        adapter.addLoadStateListener {
            errorMessage.isVisible = it.refresh is LoadState.Error
            if (firstLoading && it.refresh is LoadState.NotLoading) {
                progressBar.isVisible = false
                firstLoading = false
            }
        }
    }

    private fun setupRecyclerView(
        recyclerView: RecyclerView,
        onClickListener: View.OnClickListener
    ) {
        adapter = ItemRecyclerViewAdapter(
            onClickListener,
            ItemComparator
        )
        recyclerView.adapter = adapter.withLoadStateFooter(ItemLoadStateAdapter())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}