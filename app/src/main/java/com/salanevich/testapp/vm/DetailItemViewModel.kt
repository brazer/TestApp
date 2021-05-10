package com.salanevich.testapp.vm

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.salanevich.testapp.repository.DetailItemRepository
import com.salanevich.testapp.ui.model.ItemDetail
import kotlinx.coroutines.flow.catch

class DetailItemViewModel(
    context: Context,
    id: String
): ViewModel() {

    private val repository = DetailItemRepository(context)

    val detail = repository.getDetail(id)
        .catch { e ->
            Log.e("DetailItemViewModel", "Error", e)
            emit(null)
        }
        .asLiveData(viewModelScope.coroutineContext)

}