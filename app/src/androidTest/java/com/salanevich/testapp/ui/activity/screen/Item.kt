package com.salanevich.testapp.ui.activity.screen

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.text.KTextView
import com.salanevich.testapp.R
import org.hamcrest.Matcher

class Item(parent: Matcher<View>): KRecyclerItem<Item>(parent) {
    val title = KTextView(parent) { withId(R.id.content) }
    val image = KImageView(parent) { withId(R.id.imageHeader) }
}