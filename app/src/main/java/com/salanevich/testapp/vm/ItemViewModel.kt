package com.salanevich.testapp.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.salanevich.testapp.repository.CollectionsPagingSource

class ItemViewModel(application: Application): AndroidViewModel(application) {

    val flow = Pager(PagingConfig(20)) {
        CollectionsPagingSource(application)
    }.flow.cachedIn(viewModelScope)

}