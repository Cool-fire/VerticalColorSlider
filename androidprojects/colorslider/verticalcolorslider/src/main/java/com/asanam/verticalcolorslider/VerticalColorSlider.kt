package com.asanam.verticalcolorslider

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.lang.Exception
import kotlin.math.max
import kotlin.math.min

class VerticalColorSlider(context:Context, attrs:AttributeSet) : View(context, attrs) {
    private var requireIndicator: Boolean
    private lateinit var bitmap: Bitmap
    private var cacheBitmap: Boolean = true
    private val path: Path = Path()
    private var onColorChangeListener: OnColorChangeListener? = null
    private var selectorYPos: Float = 0F
    private lateinit var colorPickerBody: RectF
    private var colorPickerRadius: Float = 0F
    private var centerX: Int = 0
    private lateinit var paint: Paint
    private lateinit var strokePaint: Paint
    private var borderColor : Int
    private var borderWidth : Float
    private var colors : IntArray
    private var viewWidth : Int = 0
    private var viewHeight : Int = 0

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.VerticalColorSlider,
            0,0).apply {


            try {
                borderColor = this.getColor(R.styleable.VerticalColorSlider_borderColor, Color.WHITE)
                borderWidth = this.getDimension(R.styleable.VerticalColorSlider_borderWidth, 10f)
                colors = this.resources.getIntArray(this.getResourceId(R.styleable.VerticalColorSlider_colors, R.array.default_colors))
                requireIndicator = this.getBoolean(R.styleable.VerticalColorSlider_requireIndicator, false)
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
            style = Paint.Style.STROKE
            color = borderColor
            isAntiAlias = true
            strokeWidth = borderWidth
        }
    }

    private fun initializePaint() {
        paint = Paint().apply {
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        viewWidth = w
        viewHeight = h

        centerX = viewWidth/2
        colorPickerRadius = (viewWidth/2) - borderWidth
        colorPickerBody = RectF(centerX - colorPickerRadius, borderWidth + colorPickerRadius, centerX + colorPickerRadius, viewHeight - (borderWidth + colorPickerRadius))

        paint.shader = LinearGradient(0F, colorPickerBody.top,0F,colorPickerBody.bottom, colors,null,Shader.TileMode.CLAMP)

        reset()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.apply {
            addCircle(centerX.toFloat(), borderWidth + colorPickerRadius, colorPickerRadius, Path.Direction.CW)
            addRect(colorPickerBody, Path.Direction.CW)
            addCircle(centerX.toFloat(), viewHeight - (borderWidth + colorPickerRadius), colorPickerRadius, Path.Direction.CW)
        }

        canvas?.apply {
            drawPath(path, strokePaint)
            drawPath(path, paint)
        }
        if (cacheBitmap) {
            bitmap = getDrawingCache()
            cacheBitmap = false
            invalidate()
        }
        else {
            if(requireIndicator) {
                canvas?.drawLine(colorPickerBody.left, selectorYPos, colorPickerBody.right, selectorYPos, strokePaint)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        try {
            val ypos = max(colorPickerBody.top, min(event?.y!!, colorPickerBody.bottom))
            selectorYPos = ypos
            val selectedColor = bitmap.getPixel(viewWidth/2, selectorYPos.toInt())
            onColorChangeListener?.onColorChange(selectedColor)
            performClick()
            invalidate()

        } catch (e:Exception) {
            e.printStackTrace()
        }

        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    fun setBorderColor(newColor:Int) {
        borderColor = newColor
        invalidate()
    }

    fun setColors(newColors : IntArray) {
        colors = newColors
        cacheBitmap = true
        invalidate()
    }

    fun setBorderWidth(newWidth: Int) {
        borderColor = newWidth
        invalidate()
    }

    fun setIndicator(requireIndicator: Boolean = false) {
        this.requireIndicator = requireIndicator
        invalidate()
    }

    fun setOnColorChangeListener(onColorChangeListener: OnColorChangeListener) {
        this.onColorChangeListener = onColorChangeListener
    }

    private fun reset() {
        selectorYPos = borderWidth + colorPickerRadius
        onColorChangeListener?.onColorChange(Color.TRANSPARENT)
        invalidate()
    }

    interface OnColorChangeListener {
        fun onColorChange(selectedColor: Int)
    }

}