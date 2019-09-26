package com.asanam.verticalcolorslider

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class VerticalColorSlider(context:Context, attrs:AttributeSet) : View(context, attrs) {
    private lateinit var paint: Paint
    private lateinit var strokePaint: Paint
    private var borderColor : Int
    private var borderWidth : Float
    private lateinit var colors : IntArray
    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.VerticalColorSlider,
            0,0).apply {


            try {
                borderColor = this.getColor(R.styleable.VerticalColorSlider_borderColor, Color.WHITE)
                borderWidth = this.getDimension(R.styleable.VerticalColorSlider_borderWidth, 10f)
                colors = this.resources.getIntArray(this.getResourceId(R.styleable.VerticalColorSlider_colors, R.array.default_colors))
            } finally {
                this.recycle()
                initialize()
            }
        }
    }

    private fun initialize() {
        setWillNotDraw(false)
        initializePaint()
        initializeStrokePaint()
        isDrawingCacheEnabled = true
    }

    private fun initializeStrokePaint() {
        strokePaint = Paint().apply {
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }

    private fun initializePaint() {
        paint = Paint().apply {
            style = Paint.Style.STROKE
            color = borderColor
            isAntiAlias = true
            strokeWidth = borderWidth
        }
    }
}