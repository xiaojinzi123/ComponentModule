package com.xiaojinzi.component.model.develop

import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import com.xiaojinzi.component.anno.ModuleAppAnno
import com.xiaojinzi.component.application.IComponentApplication
import com.xiaojinzi.component.model.develop.anno.DevelopToolsVisible
import com.xiaojinzi.component.model.develop.extend.dp2px
import com.xiaojinzi.component.model.develop.view.DevelopView

/**
 * Develop 的生命周期类
 */
@ModuleAppAnno
class Application : IComponentApplication {

    var activityLifecycleCallback = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStarted(p0: Activity) {
        }

        override fun onActivityDestroyed(p0: Activity) {
        }

        override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        }

        override fun onActivityStopped(p0: Activity) {
        }

        override fun onActivityCreated(activity: Activity, p1: Bundle?) {
            val developToolsVisibleAnno: DevelopToolsVisible? =
                activity.javaClass.getAnnotation(DevelopToolsVisible::class.java)
            if (developToolsVisibleAnno == null || developToolsVisibleAnno.value) {
                // 拿到顶层的 View
                val decorViewGroup = activity!!.window!!.decorView as ViewGroup
                // 判断类型然后添加一个 DevelopView
                if (decorViewGroup is FrameLayout) {
                    var layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    layoutParams.gravity = (Gravity.CENTER_VERTICAL or Gravity.END)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        layoutParams.marginEnd = decorViewGroup.context.dp2px(10f)
                    } else {
                        layoutParams.rightMargin = decorViewGroup.context.dp2px(10f)
                    }
                    layoutParams.topMargin = decorViewGroup.context.dp2px(10f)
                    val developView = DevelopView(activity)
                    developView.layoutParams = layoutParams
                    decorViewGroup.addView(developView)
                }
            }

        }

        override fun onActivityResumed(p0: Activity) {
        }
    }

    var mApp: Application? = null;

    override fun onCreate(app: Application) {
        mApp = app
        app.registerActivityLifecycleCallbacks(activityLifecycleCallback)
    }

    override fun onDestroy() {
        mApp?.unregisterActivityLifecycleCallbacks(activityLifecycleCallback)
        mApp = null
    }

}