package com.example.taxyrider

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var toggle = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeImage(view: View) {
        toggle = if (toggle == 0) {
            view.setBackgroundResource(R.drawable.dinosaur_medium)
            1
        } else {
            // Add code to let your app sleep for two screen refreshes
            // before switching the background to the smaller image.
            // This means that instead of refreshing the screen every 16 ms,
            // your app now refreshes every 48 ms with new content.
            // This will be reflected in the bars displayed by the
            // Profile GPU Rendering tool.
//            try {
//                Thread.sleep(32) // two refreshes
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
            view.setBackgroundResource(R.drawable.ankylo)
            0
        }
    }
}
