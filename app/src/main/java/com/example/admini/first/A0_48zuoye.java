package com.example.admini.first;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class A0_48zuoye extends BaseActivity {
    MediaPlayer mp;
    MediaRecorder recorder;
    File file;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_48zuoye);
    }
    public void record(View view)
    {
        file = new File("/mnt/sdcard/sound.amr");
        try{
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(file.getAbsolutePath());

            recorder.prepare();
            recorder.start();
        }catch(Exception e){
            Log.e("error",e.getMessage());
        }
    }
    public void start(View view) throws IOException {
        mp=new MediaPlayer();
        mp.reset();
//        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.setDataSource("/mnt/sdcard/sound.amr");
        mp.prepare();
        mp.start();
    }
    public void stop(View view)
    {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
    }
    @Override
    protected void onDestroy() {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
        super.onDestroy();
    }
}
