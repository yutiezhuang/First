package com.example.admini.first;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 16-5-17.
 */
public class A0_tu extends BaseActivity {
    public int []a={R.drawable.gallerymin1,R.drawable.gallerymin2,R.drawable.gallerymin3,R.drawable.gallerymin4,R.drawable.gallerymin5};
    public int i=0;
    int alpha=255;
    ImageView iv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_tu);
        iv=(ImageView)findViewById(R.id.pic1);
        iv.setImageResource(a[0]);

    }
    public void ting1(View view){
    iv.setImageResource(a[Math.abs(--i)%5]);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void ting2(View view){
        alpha+=15;
        if(alpha>255){
            iv.setImageAlpha(255);
            alpha=255;
        }else{
            iv.setImageAlpha(alpha);
        }

    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void ting3(View view){
        alpha-=15;
        if(alpha<0){
            iv.setImageAlpha(0);
            alpha=0;
        }else{
            iv.setImageAlpha(alpha);
        }

    }
    public void ting4(View view){
        iv.setImageResource(a[Math.abs(++i)%5]);
    }

}
