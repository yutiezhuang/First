package com.example.admini.first;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/1.
 */
public class A0_28zuoye extends BaseActivity {
    ImageView iv;
    MediaPlayer music;
    AnimationDrawable ad;
    int n=1;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_28zuoye);
        iv= (ImageView) findViewById(R.id.image);
        ad= (AnimationDrawable) iv.getBackground();
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    ad.start();
                    if(music == null)
                    {
                        music = MediaPlayer.create(A0_28zuoye.this,R.raw.bomb);
                    }
                    music.start();
                return true;
            }
        });
        ad.stop();
    }
}
