package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by Administrator on 16-5-12.
 */
public class heart extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myview my=new myview(this);
        my.setOnTouchListener(my);
        setContentView(my);
    }
}
