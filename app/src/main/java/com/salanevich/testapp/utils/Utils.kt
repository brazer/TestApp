package com.salanevich.testapp.utils

import android.content.Context
import android.content.res.Resources
import android.os.Build
import com.salanevich.testapp.BuildConfig
import java.util.*

const val NL = "nl"
const val EN = "en"

fun Context.getCulture(): String {
    val currentLocale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        resources.configuration.locales[0]
    } else resources.configuration.locale
    return if (currentLocale.language == Locale(NL).language) NL else EN
}

fun getKey() = BuildConfig.KEY