package com.example.flightgearcontroller4.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.lang.Math.min

class Joystick @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStlyAttr: Int = 0
): View(context, attrs, defStlyAttr) {

    private val paint = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE
        color = Color.DKGRAY
        isAntiAlias = true
        strokeWidth = 50f;
    }

    private var radius: Float = 0f;
    private var center: PointF = PointF();
    private var beforeCenter: PointF = PointF();


    override fun onSizeChanged(width: Int, height: Int, oldw: Int, oldh: Int){
        radius = 0.12f*min(width, height).toFloat()
        center = PointF(width/2.0f, height/2.0f)
        invalidate()
    }
     fun reCenter(width: Int, height: Int){
        radius = 0.12f*min(width, height).toFloat()
        center = PointF(width/2.0f, height/2.0f)
         invalidate()
        //beforeCenter = center
    }

    override fun onDraw(canvas: Canvas){
        //super.onDraw(canvas); should put it??
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.setColor(Color.DKGRAY)
        canvas.drawCircle(center.x, center.y, radius, paint)

        paint.setColor(Color.GRAY)
        paint.style=Paint.Style.STROKE
        canvas.drawCircle(center.x, center.y, radius, paint)
    }
    //private pointerToFunc

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event==null){
            return true
        }
        when (event?.action){
            MotionEvent.ACTION_DOWN -> touchMove(event.x, event.y)
            MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
            MotionEvent.ACTION_UP -> {//debug(2f*((center.x-(radius+paint.strokeWidth))/(width.toFloat()-2f*(radius+paint.strokeWidth))) -1f,
                //(2f*((center.y-(radius+paint.strokeWidth))/(height.toFloat()-2f*(radius+paint.strokeWidth))) -1f)*-1f)
                reCenter(width, height)}
        }
        return true
    }

/*    private fun releaseMovement (){
        center.x=x;
        center.y=y;
        invalidate()
    }*/
    public lateinit var d: (x: Float, y: Float) -> Unit
    public lateinit var debug: (x: Float, y: Float)->Unit

/*    public lateinit var s: stragedyJoy
    class stragedyJoy(val temp: (x: Float, y: Float) -> Any) {
        var do_it = temp
    }*/

    private fun touchMove (x: Float, y: Float){
        var tempX: Float = x;
        var tempY: Float = y;
        var radiusWithStroke: Float = radius+paint.strokeWidth;
        if (x+radiusWithStroke>width){
            tempX=width-radiusWithStroke;
        }
        else if (x-radiusWithStroke<0){
            tempX=radiusWithStroke;
        }
        if (y+radiusWithStroke>height){
            tempY=height-radiusWithStroke;
        }
        else if (y-radiusWithStroke<0){
            tempY=radiusWithStroke;
        }
        center.x=tempX
        center.y=tempY
        //s.do_it(x,y)
        d(2f*((center.x-radiusWithStroke)/(width.toFloat()-2f*radiusWithStroke)) -1f
            ,(2f*((center.y-radiusWithStroke)/(height.toFloat()-2f*radiusWithStroke)) -1f)*-1f)
        //do_it(x,y)
        //center.y +=20
        //pointerToFunc(x,y);
        invalidate()
    }
}

//21.6 00:15