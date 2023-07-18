package com.hrm.turinginversion.base.utils

import android.content.Context
import android.os.Build
import android.provider.Settings.Secure
import android.telephony.TelephonyManager
import com.hrm.turinginversion.base.BaseApplication

val imei: String by lazy {
    val telephonyManager = BaseApplication.instance.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return@lazy if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val imeiFromTelephonyManager = telephonyManager.getImei(0)
        imeiFromTelephonyManager ?: ""
    } else {
        @Suppress("deprecation")
        val deviceId = telephonyManager.deviceId
        deviceId ?: ""
    }
}

val androidId: String by lazy {
    return@lazy try {
        Secure.getString(BaseApplication.instance.contentResolver, Secure.ANDROID_ID)
    } catch (t: Throwable) {
        ""
    }
}

val model: String by lazy {
    Build.MODEL
}
