[![](https://jitpack.io/v/Cool-fire/VerticalColorSlider.svg)](https://jitpack.io/#Cool-fire/VerticalColorSlider)
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=plastic)](https://developer.android.com/studio/releases/platforms)

# VerticalColorSlider

## VerticalColorSlider is a color-picker library where you can slide to pick an color in Android.

This is an Re-Implementation of [Vertical-color-slider-picker](https://github.com/veritas1/vertical-slide-color-picker) in kotlin, Since the original 
repo is stale and not accepting any PR's.

## Demo

![Colorslider](https://user-images.githubusercontent.com/25877454/65792469-787d0200-e181-11e9-8f8c-04a7e58ad751.gif)


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
     implementation 'com.github.Cool-fire:VerticalColorSlider:1.0.0'
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
  
## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/Cool-fire/VerticalColorSlide/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated.


## All credit goes to

[veritsa1](https://github.com/veritas1/)
