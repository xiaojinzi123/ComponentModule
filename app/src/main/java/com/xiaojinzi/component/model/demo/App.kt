package com.xiaojinzi.component.model.demo

import android.app.Application
import com.xiaojinzi.component.Component
import com.xiaojinzi.component.Config
import com.xiaojinzi.component.impl.application.ModuleManager

class App : Application() {

    override
    fun onCreate() {
        super.onCreate()

        Component.init(
            BuildConfig.DEBUG,
            Config
                .Builder(this)
                .defaultScheme("router")
                .tipWhenUseApplication(true)
                .build()
        )

        ModuleManager.getInstance().registerArr("app", "develop")

    }

}