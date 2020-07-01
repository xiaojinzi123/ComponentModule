package com.xiaojinzi.component.model.develop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaojinzi.component.anno.RouterAnno
import com.xiaojinzi.component.model.develop.R
import com.xiaojinzi.component.model.develop.anno.DevelopToolsVisible

@RouterAnno(
    host = "develop",
    path = "main"
)
@DevelopToolsVisible(false)
class DevelopAct : AppCompatActivity() {

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.develop_act)
    }

}