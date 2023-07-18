package com.hrm.turinginversion.base.monitor

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import java.util.concurrent.CopyOnWriteArrayList

/**
 * App前后台监听
 */
object AppStateMonitor : LifecycleEventObserver {
    private val listeners: MutableList<AppStateChangeListener> = CopyOnWriteArrayList()
    private var isAppForeground = false

    init {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    interface AppStateChangeListener {
        fun onEnterBackground()
        fun onEnterForeground()
    }

    fun addListener(listener: AppStateChangeListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: AppStateChangeListener) {
        listeners.remove(listener)
    }

    /**
     * App 是否在前台
     */
    fun isAppForeground(): Boolean {
        return isAppForeground
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_STOP) {
            isAppForeground = false
            for (listener in listeners) {
                listener.onEnterBackground()
            }
        } else if (event == Lifecycle.Event.ON_START) {
            isAppForeground = true
            for (listener in listeners) {
                listener.onEnterForeground()
            }
        }
    }
}