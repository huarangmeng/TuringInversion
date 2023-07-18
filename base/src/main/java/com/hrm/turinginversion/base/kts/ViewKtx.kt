package com.hrm.turinginversion.base.kts

import android.content.Context
import android.content.res.Resources

fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

fun getScreenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
}

fun dip2px(context: Context, dpValue: Float): Float {
    val scale = getDensityByContext(context)
    return dpValue * scale + 0.5f
}

fun getDensityByContext(context: Context): Float {
    val dm = context.resources.displayMetrics
    return dm.density
}