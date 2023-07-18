package com.hrm.turinginversion.base.utils

import android.util.Base64
import java.io.UnsupportedEncodingException

fun decryptBASE64(str: String?): String? {
    if (str.isNullOrEmpty()) {
        return null
    }
    try {
        val encode = str.toByteArray(charset("UTF-8"))
        // base64 解密
        return String(Base64.decode(encode, 0, encode.size, Base64.DEFAULT), Charsets.UTF_8)
    } catch (e: UnsupportedEncodingException) {
        e.printStackTrace()
    }
    return null
}