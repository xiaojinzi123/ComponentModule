package com.xiaojinzi.component.model.develop.view

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.xiaojinzi.component.model.develop.R


class BaseInfoDialog(context: Activity) : Dialog(context, R.style.Develop_BaseInfoDialog) {


    /**
     * 确认和取消按钮
     */
    private var negtiveBn: Button? = null

    /**
     * 确认和取消按钮
     */
    private var positiveBn: Button? = null

    private val activityName: String = context.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.develop_baseinfo_dialog)
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false)
        findViewById<TextView>(R.id.activityName).text = activityName
        //设置确定按钮被点击后，向外界提供监听
        findViewById<Button>(R.id.negtive)?.setOnClickListener(object : View.OnClickListener {
            override
            fun onClick(v: View?) {
                dismiss()
            }
        })
        //设置取消按钮被点击后，向外界提供监听
        findViewById<Button>(R.id.positive)?.setOnClickListener(object : View.OnClickListener {
            override
            fun onClick(v: View?) {
                dismiss()
            }
        })
    }



}