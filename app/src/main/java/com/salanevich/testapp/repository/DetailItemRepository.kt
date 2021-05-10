package com.salanevich.testapp.repository

import android.content.Context
import com.salanevich.testapp.ui.model.ItemDetail
import kotlinx.coroutines.flow.Flow

class DetailItemRepository(context: Context) {

    private val source = DetailItemDataSource(context)

    fun getDetail(id: String): Flow<ItemDetail?> = source.getDetail(id)

}