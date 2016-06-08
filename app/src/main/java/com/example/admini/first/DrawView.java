package com.example.admini.first;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/6/1.
 */
public class DrawView extends View implements View.OnTouchListener {
    public DrawView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
