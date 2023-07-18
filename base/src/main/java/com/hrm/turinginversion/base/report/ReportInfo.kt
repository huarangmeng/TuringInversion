package com.hrm.turinginversion.base.report

import com.hrm.turinginversion.base.log.XLog

const val REPORT_TAG = "report_tag"

class ReportInfo private constructor(
    val reportElement: String?,
    val actionId: Int = DEFAULT_ACTION_ID,
    val scene: Int = DEFAULT_SCENE,
    val sourceScene: Int = DEFAULT_SCENE,
    val extraMap: MutableMap<String, String> = mutableMapOf()
) {

    fun report() {
        XLog.d(REPORT_TAG, this.toString())
    }

    override fun toString(): String {
        return "ReportInfo(reportElement=$reportElement, actionId=$actionId, scene=$scene, sourceScene=$sourceScene, extraMap=$extraMap)"
    }

    data class Builder(
        private var reportElement: String? = null,
        private var actionId: Int = DEFAULT_ACTION_ID,
        private var scene: Int = DEFAULT_SCENE,
        private var sourceScene: Int = DEFAULT_SCENE,
        private var extraMap: MutableMap<String, String> = mutableMapOf()
    ) {
        fun reportElement(reportElement: String) = apply { this@Builder.reportElement = reportElement }
        fun actionId(actionId: Int) = apply { this@Builder.actionId = actionId }
        fun scene(scene: Int) = apply { this@Builder.scene = scene }
        fun sourceScene(sourceScene: Int) = apply { this@Builder.sourceScene = sourceScene }
        fun extraMap(extraMap: MutableMap<String, String>) = apply { this@Builder.extraMap = extraMap }
        fun build() = ReportInfo(reportElement, actionId, scene, sourceScene, extraMap)
    }
}