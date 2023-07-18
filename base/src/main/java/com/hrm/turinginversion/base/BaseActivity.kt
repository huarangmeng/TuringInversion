package com.hrm.turinginversion.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.hrm.turinginversion.base.report.ACTION_PAGE_IN
import com.hrm.turinginversion.base.report.ACTION_PAGE_OUT
import com.hrm.turinginversion.base.report.DEFAULT_SCENE
import com.hrm.turinginversion.base.report.PAGE
import com.hrm.turinginversion.base.report.ReportInfo
import com.hrm.turinginversion.base.report.SOURCE_SCENE


open class BaseActivity : ComponentActivity() {

    private var sourceScene: Int = DEFAULT_SCENE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPageData()
    }

    override fun onResume() {
        super.onResume()
        reportPageIn()
    }

    override fun onPause() {
        super.onPause()
        reportPageOut()
    }

    open fun getScene(): Int {
        return DEFAULT_SCENE
    }

    private fun initPageData() {
        sourceScene = intent.extras?.getInt(SOURCE_SCENE, DEFAULT_SCENE) ?: DEFAULT_SCENE
    }

    private fun reportPageIn() {
        val reportInfo = ReportInfo.Builder()
                .reportElement(PAGE)
                .actionId(ACTION_PAGE_IN)
                .scene(getScene())
                .sourceScene(sourceScene)
                .build()
        reportInfo.report()
    }

    private fun reportPageOut() {
        val reportInfo = ReportInfo.Builder()
                .reportElement(PAGE)
                .actionId(ACTION_PAGE_OUT)
                .scene(getScene())
                .sourceScene(sourceScene)
                .build()
        reportInfo.report()
    }
}