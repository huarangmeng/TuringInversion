package com.hrm.turinginversion.base.utils

import androidx.annotation.Nullable
import java.io.BufferedReader
import java.io.InputStreamReader

object SystemPropertiesProxy {

    @Nullable
    operator fun get(key: String): String? {
        require(key.length <= 31) { "key.length > 31" }
        return getProperty(key, null)
    }

    @Nullable
    operator fun get(key: String, def: String?): String? {
        require(key.length <= 31) { "key.length > 31" }
        return getProperty(key, def)
    }

    fun getInt(key: String, def: Int): Int {
        require(key.length <= 31) { "key.length > 31" }
        return getPropertyInt(key, def)
    }

    fun getLong(key: String, def: Long): Long {
        require(key.length <= 31) { "key.length > 31" }
        return getPropertyLong(key, def)
    }

    fun getBoolean(key: String, def: Boolean): Boolean {
        require(key.length <= 31) { "key.length > 31" }
        return getPropertyBoolean(key, def)
    }

    @Nullable
    private fun getProperty(key: String, @Nullable defaultValue: String?): String? {
        val value: String?
        var mProcess: Process? = null
        try {
            mProcess = Runtime.getRuntime().exec("getprop $key")
            val br = BufferedReader(
                InputStreamReader(
                    mProcess.inputStream
                )
            )
            value = br.readLine()
        } catch (e: Exception) {
            // 获取不到的话，如果是null，那么不能返回"" 防止外部逻辑错误
            return defaultValue
        } finally {
            if (mProcess != null) {
                try {
                    mProcess.destroy()
                } catch (_: Exception) {
                }
            }
        }
        return value?.trim { it <= ' ' } ?: ""
    }

    private fun getPropertyInt(key: String, defaultValue: Int): Int {
        val value = getProperty(key, null)
        var valueInt = defaultValue
        if (value != null) {
            try {
                valueInt = value.toInt()
            } catch (e: Exception) {
                //empty
            }
        }
        return valueInt
    }

    private fun getPropertyLong(key: String, defaultValue: Long): Long {
        val value = getProperty(key, null)
        var valueInt = defaultValue
        if (value != null) {
            try {
                valueInt = value.toLong()
            } catch (e: Exception) {
                //empty
            }
        }
        return valueInt
    }

    private fun getPropertyBoolean(key: String, defaultValue: Boolean): Boolean {
        val value = getProperty(key, null)
        var valueBoolean = defaultValue
        if (value != null) {
            try {
                valueBoolean = java.lang.Boolean.parseBoolean(value)
            } catch (e: Exception) {
                //empty
            }
        }
        return valueBoolean
    }
}