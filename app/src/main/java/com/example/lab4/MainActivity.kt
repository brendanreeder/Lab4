package com.example.lab4

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.ImageButton
import com.example.lab4.MyCanvasView.Companion.colorList
import com.example.lab4.MyCanvasView.Companion.currentBrush
import com.example.lab4.MyCanvasView.Companion.pathList

class MainActivity : AppCompatActivity() {

    companion object {
        var path = Path()
        var paintBrush = Paint()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val redBtn = findViewById<ImageButton>(R.id.red_color)
        val orngBtn = findViewById<ImageButton>(R.id.orange_color)
        val ylwBtn = findViewById<ImageButton>(R.id.yellow_color)
        val grnBtn = findViewById<ImageButton>(R.id.green_color)
        val blueBtn = findViewById<ImageButton>(R.id.blue_color)
        val prplBtn = findViewById<ImageButton>(R.id.purple_color)
        val blkBtn = findViewById<ImageButton>(R.id.black_color)
        val clear = findViewById<ImageButton>(R.id.white_color)

        redBtn.setOnClickListener{
            paintBrush.color = resources.getColor(R.color.red)
            currentColor(paintBrush.color)
        }
        orngBtn.setOnClickListener{
            paintBrush.color = resources.getColor(R.color.orange)
            currentColor(paintBrush.color)
        }
        ylwBtn.setOnClickListener {
            paintBrush.color = resources.getColor(R.color.yellow)
            currentColor(paintBrush.color)
        }
        grnBtn.setOnClickListener {
            paintBrush.color = resources.getColor(R.color.green)
            currentColor(paintBrush.color)
        }
        blueBtn.setOnClickListener{
            paintBrush.color = resources.getColor(R.color.blue)
            currentColor(paintBrush.color)
        }
        prplBtn.setOnClickListener{
            paintBrush.color = resources.getColor(R.color.purple)
            currentColor(paintBrush.color)
        }
        blkBtn.setOnClickListener {
            paintBrush.color = resources.getColor(R.color.black)
            currentColor(paintBrush.color)
        }
        clear.setOnClickListener {
            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }
}