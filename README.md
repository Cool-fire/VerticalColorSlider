# VerticalColorSlider

## VerticalColorSlider is a color-picker library where you can slide to pick an color in Android.

This is an Re-Implementation of [Vertical-color-slider-picker](https://github.com/veritas1/vertical-slide-color-picker) in kotlin, Since the original 
repo is stale and not accepting any PR's.

## Usage
### Quick start

- Gradle:

  ## 1. build.gradle(Project)

     ```
     allprojects {
         repositories {
             maven { url "https://jitpack.io" }
             jcenter()
         }
     }
     ```

  ## 2. build.gradle (App)

     ```
     implementaion 'com.asanam.colorslider:verticalcolorslider:1.0.0'
     ```
  ```
- In xml:
```xml
<com.asanam.verticalcolorslider.VerticalColorSlider
        android:id="@+id/color_slider"
        android:layout_width="20dp"
        android:layout_height="500dp"
        android:layout_marginEnd="20dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:borderColor="@android:color/white"
        app:requireIndicator="true"
        app:initialColor="@android:color/black"
        app:borderWidth="2dp"
        app:colors="@array/array_colors"/>
```
- In code:

  ```kotlin
   color_slider.setOnColorChangeListener(object : VerticalColorSlider.OnColorChangeListener{
            override fun onColorChange(selectedColor: Int) {
                 // Your code
            }
        })
  ```
### API

- Properties

1. Common attributes:

   | Attribute              | Description                                                  |
   | ---------------------- | ------------------------------------------------------------ |
   | borderColor  | Color for border default to White                        |
   | borderWidth          | Width for border                            |
   | requireIndicator          |Require indicator or not default to false                           |
   | initialColor           | Initial color to be selected default to Black                               |
   | colors              | Array of colors in xml format                          |
  

## All credit goes to

[veritsa1](https://github.com/veritas1/)
