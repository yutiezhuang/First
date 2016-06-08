package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/26.
 */
//public class A0_04Activiy extends BaseActivity{
//    int[] str={R.drawable.gallerymin1,R.drawable.gallerymin2,R.drawable.gallerymin3,R.drawable.gallerymin4,R.drawable.gallerymin5};
//    int a=0;
//    @Override
//    protected void initContentView(Bundle savedInstanceState) {
//        setContentView(R.layout.a0_04layout);
//        final ImageView iv= (ImageView) findViewById(R.id.image);
//        iv.setImageResource(str[0]);
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                iv.setImageResource(str[++a%str.length]);
//            }
//        });
//    }
//}
public class A0_04Activiy extends BaseActivity {
    int[] str={R.drawable.gallerymin1,R.drawable.gallerymin2,R.drawable.gallerymin3,R.drawable.gallerymin4,R.drawable.gallerymin5};
    int a=0;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
       //super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_04layout);
       final ImageView iv= (ImageView) findViewById(R.id.image);
        iv.setImageResource(str[0]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(str[++a%str.length]);
            }
        });

    }

}
