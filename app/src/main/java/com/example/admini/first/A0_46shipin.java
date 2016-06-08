package com.example.admini.first;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by Administrator on 2016/6/8.
 */
public class A0_46shipin extends BaseActivity {
    VideoView vv;
    MediaController mc;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.a0_46shipin);
        vv= (VideoView) findViewById(R.id.video);
        mc=new MediaController(this);
        File video=new File("/mnt/sdcard/mm.mp4");
        if (video.exists()){
            vv.setVideoPath(video.getAbsolutePath());
            vv.setMediaController(mc);
            mc.setMediaPlayer(vv);
            vv.requestFocus();
        }
    }
}
