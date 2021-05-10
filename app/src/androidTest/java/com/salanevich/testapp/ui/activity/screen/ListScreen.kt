package com.salanevich.testapp.ui.activity.screen

import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.salanevich.testapp.R

class ListScreen: Screen<ListScreen>() {
    val recycler = KRecyclerView({
        withId(R.id.item_list)
    }, itemTypeBuilder = {
        itemType(::Item)
    })
}