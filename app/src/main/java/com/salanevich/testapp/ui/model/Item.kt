package com.salanevich.testapp.ui.model

data class Item(
    val id: String,
    val name: String,
    val image: Image?
) {
    data class Image(val url: String, val height: Int?, val width: Int?)
}