package com.salanevich.testapp.repository

import com.salanevich.testapp.model.ArtObjectsItem
import com.salanevich.testapp.model.CollectionsResponse
import com.salanevich.testapp.model.ItemDetailResponse
import com.salanevich.testapp.ui.model.Item
import com.salanevich.testapp.ui.model.ItemDetail
import java.util.ArrayList

fun CollectionsResponse.map(): List<Item> {
    val items = ArrayList<Item>()
    artObjects?.forEach { obj ->
        if (obj?.objectNumber != null && obj.longTitle != null) {
            Item(
                id = obj.objectNumber,
                name = obj.longTitle,
                image = getImage(obj)
            ).also { items.add(it) }
        }
    }
    return items
}

private fun getImage(obj: ArtObjectsItem): Item.Image? = if (obj.headerImage?.url != null) {
        Item.Image(
            url = obj.headerImage.url,
            height = obj.headerImage.height,
            width = obj.headerImage.width
        )
} else null

fun ItemDetailResponse.map(): ItemDetail? = if (artObject != null) {
    ItemDetail(
        title = artObject.title ?: "Empty",
        subTitle = artObject.longTitle ?: "Empty",
        author = artObject.label?.makerLine,
        description = artObject.description,
        imageUrl = artObject.webImage?.url
    )
} else null