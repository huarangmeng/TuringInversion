package com.hrm.turinginversion.base

import android.app.Application
import android.content.Context

open class BaseApplication : Application() {

    companion object {
        private const val TAG = "BaseApplication"
        lateinit var instance: Application
            private set
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        instance = this
    }
}