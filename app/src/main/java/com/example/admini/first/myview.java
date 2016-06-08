package com.example.admini.first;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-12.
 */
public class myview extends View implements View.OnTouchListener {
    Canvas canvas;
    Bitmap bitmap;
    List<point> list = new ArrayList<point>();
    public float cx = 300;
    public float cy = 300;

    public myview(Context context) {
        super(context);
        bitmap = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        canvas = new Canvas();
        canvas.setBitmap(bitmap);
    }

    public myview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Paint p1 = new Paint();
        p1.setAntiAlias(true);
        p1.setStrokeWidth(8);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            cx = event.getX();
            cy = event.getY();
            int color = 0xff000000 + (int) (Math.random() * 0xffffff);
            p1.setColor(color);
//            p1.setXx(cx);
//            p1.setYy(cy);
            for (float x = -2; x <= 2; x += 0.01) {
                float y = -(float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
                float b = -(float) ((-2.14) * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
                canvas.drawPoint(x * 50 + cx, y * 50 + cy, p1);
                canvas.drawPoint(x * 50 + cx, b * 50 + cy, p1);
            }
            for (float x = -2; x <= 2; x += 0.01) {
                float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
                float b = (float) ((-2.14) * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
                canvas.drawPoint(x * 50 + cx, y * 50 + cy-100, p1);
                canvas.drawPoint(x * 50 + cx, b * 50 + cy-100, p1);
            }
            invalidate();
        }
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        canvas.drawBitmap(bitmap,0,0,p);
        // canvas.drawCircle(cx,cy,50,p);
    }
}
