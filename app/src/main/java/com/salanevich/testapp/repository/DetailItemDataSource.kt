package com.salanevich.testapp.repository

import android.content.Context
import com.salanevich.testapp.network.WebService
import com.salanevich.testapp.ui.model.ItemDetail
import com.salanevich.testapp.utils.getCulture
import com.salanevich.testapp.utils.getKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailItemDataSource(private val context: Context) {

    fun getDetail(id: String): Flow<ItemDetail?> = flow {
        emit(WebService.service.getItemDetail(context.getCulture(), id, getKey()).map())
    }

}