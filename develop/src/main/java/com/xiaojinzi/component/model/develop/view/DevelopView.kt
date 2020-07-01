package com.xiaojinzi.component.model.develop.view

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.xiaojinzi.component.impl.Router
import com.xiaojinzi.component.model.develop.extend.dp2px
import java.lang.ref.WeakReference

class DevelopView @JvmOverloads constructor(
    context: Activity,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    var paint: Paint? = null
    val weakActivity = WeakReference(context);

    init {
        gravity = Gravity.CENTER
        paint = Paint()
        paint!!.color = Color.parseColor("#FFB0CA1A")
        setOnClickListener {
            Router.with(getContext())
                .host("develop")
                .path("main")
                .forward()
        }
        setOnLongClickListener {
            if (weakActivity.get() != null) {
                BaseInfoDialog(weakActivity.get()!!).show()
            }
            return@setOnLongClickListener true
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(context.dp2px(40F), context.dp2px(40F))
    }

    override
    fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val radius = width / 2f
        canvas?.drawCircle(radius, radius, radius, paint!!)
    }

}