/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.lab4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import com.example.lab4.MainActivity.Companion.paintBrush
import com.example.lab4.MainActivity.Companion.path

private const val STROKE_WIDTH = 12f

/**
 * Custom view that follows touch events to draw on a canvas.
 */
class MyCanvasView: View {

    var params: ViewGroup.LayoutParams? = null

    companion object{
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    constructor(context: Context): this(context, null){
        init()
    }

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0){
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        init()
    }

    private fun init(){
        paintBrush.isAntiAlias = true
        paintBrush.color = currentBrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = STROKE_WIDTH

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    }

    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f

    override fun onDraw(canvas: Canvas) {

        for(i in pathList.indices){
            paintBrush.color = colorList[i]
            canvas.drawPath(pathList[i], paintBrush)
            invalidate()
        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(motionTouchEventX, motionTouchEventY)
                return true
            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(motionTouchEventX, motionTouchEventY)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else -> return false
        }
        postInvalidate()
        return false
    }

}