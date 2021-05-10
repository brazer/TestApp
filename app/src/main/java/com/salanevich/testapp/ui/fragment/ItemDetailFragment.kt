package com.salanevich.testapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import coil.load
import com.salanevich.testapp.R
import com.salanevich.testapp.databinding.FragmentItemDetailBinding
import com.salanevich.testapp.vm.DetailItemViewModel
import java.lang.IllegalArgumentException

class ItemDetailFragment : Fragment() {

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }

    private lateinit var itemId: String

    private val viewModel: DetailItemViewModel by viewModels { ViewModelFactory() }

    private var _binding: FragmentItemDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(view.context, R.color.white))
        binding.toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(view.context, R.color.white))
        binding.progressBar.isVisible = true
        viewModel.detail.observe(viewLifecycleOwner) { item ->
            item?.let {
                binding.progressBar.isVisible = false
                binding.toolbarLayout.title = it.title
                binding.detailImage.load(it.imageUrl) {
                    allowHardware(false)
                    listener({
                        binding.imageProgressBar.isVisible = true
                    }, {}, {_, _ ->}, { _, _ ->
                        binding.imageProgressBar.isVisible = false
                    })
                }
                binding.itemDetailSubTitle.text = getString(R.string.detail_title, it.subTitle)
                if (it.author != null) {
                    binding.itemDetailAuthor.text = getString(R.string.detail_author, it.author)
                } else binding.itemDetailAuthor.isVisible = false
                if (it.description != null) {
                    binding.itemDetailDesc.text = getString(R.string.detail_description, it.description)
                } else binding.itemDetailDesc.isVisible = false
            }
            if (item == null) {
                Toast.makeText(view.context, "Something went wrong", Toast.LENGTH_SHORT).show()
                view.findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private inner class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            arguments?.let {
                if (it.containsKey(ARG_ITEM_ID)) {
                    itemId = it.getString(ARG_ITEM_ID) ?: throw IllegalArgumentException("There is no ID")
                    return DetailItemViewModel(context!!, itemId) as T
                }
            }
            throw IllegalArgumentException("There are no arguments")
        }
    }

}