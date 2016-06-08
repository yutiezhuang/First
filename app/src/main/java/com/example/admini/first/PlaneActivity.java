package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/6/1.
 */
public class PlaneActivity extends Activity {
    int width;
    int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics m=new DisplayMetrics();
//        DisplayMetrics dm = getResources().getDisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(m);
         width = m.widthPixels;
         height = m.heightPixels;

        PlaneView p = new PlaneView(this,width,height);

        setContentView(p);
        p.setOnTouchListener(p);
    }
}
