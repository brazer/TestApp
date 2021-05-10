package com.salanevich.testapp.repository

import android.content.Context
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.salanevich.testapp.network.WebService
import com.salanevich.testapp.ui.model.Item
import com.salanevich.testapp.utils.getCulture
import com.salanevich.testapp.utils.getKey

class CollectionsPagingSource(context: Context): PagingSource<Int, Item>() {

    private val culture = context.getCulture()

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val nextPageNumber = params.key ?: 1
            val size = params.loadSize
            val response = WebService.service.getItems(culture, getKey(), nextPageNumber, size)
            LoadResult.Page(
                data = response.map(),
                prevKey = null,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}