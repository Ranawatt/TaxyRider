package com.example.taxyrider.memoryoverload

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taxyrider.R
import java.util.*


class MemoryActivity : AppCompatActivity() {

    val NO_OF_TEXTVIEWS_ADDED = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)
    }

    /**
     * Adds a new row of text views when the floating action button is pressed.
     */
    fun addRowOfTextViews(view: View?) {
        val root: LinearLayout = findViewById(R.id.rootLinearLayout)
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.HORIZONTAL
        val linearLayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        linearLayout.layoutParams = linearLayoutParams
        val textViewParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val textViews = arrayOfNulls<TextView>(NO_OF_TEXTVIEWS_ADDED)
        for (i in 0 until NO_OF_TEXTVIEWS_ADDED) {
            textViews[i] = TextView(this)
            textViews[i]!!.layoutParams = textViewParams
            textViews[i]!!.text = i.toString()
            textViews[i]!!.setBackgroundColor(getRandomColor())
            linearLayout.addView(textViews[i])
        }
        root.addView(linearLayout)
    }

    /**
     * Creates a random color for background color of the text view.
     */
    private fun getRandomColor(): Int {
        val r = Random()
        val red: Int = r.nextInt(255)
        val green: Int = r.nextInt(255)
        val blue: Int = r.nextInt(255)
        return Color.rgb(red, green, blue)
    }
}
