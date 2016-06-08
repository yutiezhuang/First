package com.example.admini.first;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;


/**
 * Created by Administrator on 2016/6/8.
 */
public class A0_45zuoye extends BaseActivity implements GestureDetector.OnGestureListener {
    GestureDetector detector;
    ImageView iv;
    Bitmap bitmap;
    int width,height;
    float currentScale=1;
    Matrix matrix;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_45zuoye);
        detector=new GestureDetector(this,this);
        iv= (ImageView) findViewById(R.id.image);
        matrix=new Matrix();
        bitmap= BitmapFactory.decodeResource(this.getResources(),R.drawable.a04);
        width=bitmap.getWidth();
        height=bitmap.getHeight();
        iv.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.a04));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        velocityX =velocityX>4000?4000:velocityX;
        velocityX=velocityX<-4000?-4000:velocityX;
        currentScale+=currentScale*velocityX/4000.0f;
        currentScale=currentScale>0.01?currentScale:0.01f;
        matrix.reset();
        matrix.setScale(currentScale,currentScale,160,200);
        BitmapDrawable bd= (BitmapDrawable) iv.getDrawable();
        if (!bd.getBitmap().isRecycled()){
            bd.getBitmap().isRecycled();
        }
        Bitmap bitmap2=Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        iv.setImageBitmap(bitmap2);
        return true;
    }
}
