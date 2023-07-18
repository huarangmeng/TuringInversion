package com.hrm.turinginversion.base.utils

import android.os.Build

object SystemUtils {

    private val MARK = getManufacturer().lowercase()
    private const val MASK_HUAWEI = "huawei"
    private const val MASK_XIAOMI = "xiaomi"
    private const val MASK_OPPO = "oppo"
    private const val MASK_VIVO = "vivo"
    private const val MASK_SAMSUNG = "samsung"
    private const val MASK_MEIZU = "meizu"
    private const val MASK_LENOVO = "lenovo"
    private const val MASK_NUBIA = "nubia"
    private const val MASK_ZTE = "zte"

    @JvmStatic
    fun isHuaWei(): Boolean {
        return MARK.contains(MASK_HUAWEI)
    }

    @JvmStatic
    fun isXiaoMi(): Boolean {
        return MARK.contains(MASK_XIAOMI)
    }

    @JvmStatic
    fun isOppo(): Boolean {
        return MARK.contains(MASK_OPPO)
    }

    @JvmStatic
    fun isVivo(): Boolean {
        return MARK.contains(MASK_VIVO)
    }

    @JvmStatic
    fun isSamsung(): Boolean {
        return MARK.contains(MASK_SAMSUNG)
    }

    @JvmStatic
    fun isMeizu(): Boolean {
        return MARK.contains(MASK_MEIZU)
    }

    @JvmStatic
    fun isLenovo(): Boolean {
        return MARK.contains(MASK_LENOVO)
    }

    @JvmStatic
    fun isZTE(): Boolean {
        return MARK.contains(MASK_NUBIA) || MARK.contains(MASK_ZTE)
    }

    @JvmStatic
    fun getManufacturer(): String {
        return Build.MANUFACTURER
    }
}