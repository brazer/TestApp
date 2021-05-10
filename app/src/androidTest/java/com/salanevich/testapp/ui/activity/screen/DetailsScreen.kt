package com.salanevich.testapp.ui.activity.screen

import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.salanevich.testapp.R

class DetailsScreen: Screen<DetailsScreen>() {
    val image = KImageView { withId(R.id.detail_image) }
    val title = KTextView { withId(R.id.item_detail_sub_title) }
}