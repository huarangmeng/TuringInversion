package com.hrm.turinginversion.base.log

import android.util.Log

object XLog {
    private var logger: ILogger = AndroidLogger()
    private var logLevel = Log.VERBOSE

    @JvmStatic
    fun setLogger(logger: ILogger) {
        XLog.logger = logger
    }

    @JvmStatic
    fun setLogLevel(level: Int) {
        logLevel = level
    }

    @JvmStatic
    fun v(tag: String, message: String) {
        if (logLevel > Log.VERBOSE) {
            return
        }
        logger.v(tag, message)
    }

    @JvmStatic
    fun d(tag: String, message: String) {
        if (logLevel > Log.DEBUG) {
            return
        }
        logger.d(tag, message)
    }

    @JvmStatic
    fun i(tag: String, message: String) {
        if (logLevel > Log.INFO) {
            return
        }
        logger.i(tag, message)
    }

    @JvmStatic
    fun w(tag: String, message: String) {
        if (logLevel > Log.WARN) {
            return
        }
        logger.w(tag, message)
    }

    @JvmStatic
    fun e(tag: String, message: String) {
        if (logLevel > Log.ERROR) {
            return
        }
        logger.e(tag, message)
    }

    @JvmStatic
    fun e(tag: String, message: String, throwable: Throwable) {
        if (logLevel > Log.ERROR) {
            return
        }
        logger.e(tag, message, throwable)
    }
}