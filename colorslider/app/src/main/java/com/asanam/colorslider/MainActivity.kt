package com.asanam.colorslider

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asanam.verticalcolorslider.VerticalColorSlider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        color_slider.setOnColorChangeListener(object : VerticalColorSlider.OnColorChangeListener{
            override fun onColorChange(selectedColor: Int) {
                text.setTextColor(selectedColor)
            }
        })

        color_slider.setIndicator(true)
        color_slider.setBorderColor(Color.BLACK)
        color_slider.setInitialColor(Color.BLACK)
    }
}
