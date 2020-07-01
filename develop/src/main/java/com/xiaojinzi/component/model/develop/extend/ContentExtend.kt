package com.xiaojinzi.component.model.develop.extend

import android.content.Context

fun Context.dp2px(dpValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}