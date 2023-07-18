package com.hrm.turinginversion.base.kts

import android.graphics.Color
import android.text.TextUtils

const val COLOR_PREFIX_CHAR: Char = '#'

fun parserColor(color: String): Int {
    return parserColor(color, Color.TRANSPARENT)
}

fun parserColor(color: String, defaultColor: Int): Int {
    if (TextUtils.isEmpty(color)) {
        return defaultColor
    }
    try {
        val trimColor = color.trim()
        return if (trimColor.startsWith(COLOR_PREFIX_CHAR)) {
            Color.parseColor(trimColor)
        } else {
            Color.parseColor(COLOR_PREFIX_CHAR + trimColor)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return defaultColor
}