package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
;

/**
 * Created by Administrator on 16-5-23.
 */
//public class A01_ProgressBar extends Activity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.a01_progressbar);
//        ProgressBar pb= (ProgressBar) findViewById(R.id.pgb);
//
//    }
//}
        import android.os.Handler;
        import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
        import android.widget.SeekBar;
/**
 * Created by Administrator on 16-5-23.
 */
public class A01_ProgressBar extends BaseActivity {
   int data;
    Handler h = new Handler(){
        public void handleMessage(android.os.Message msg) {
//            img.setAlpha(msg.what);
           if(msg.what==0x99){
               img1.setVisibility(View.GONE);
           }else {
               pb.setProgress(data);
           }
        };
    };

    SeekBar sb ;
    RatingBar rb ;
    ImageView img;
    ImageView img1;
    ProgressBar pb;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.a01_progressbar);
        sb = (SeekBar) findViewById(R.id.sb);
        rb = (RatingBar) findViewById(R.id.rb);
        img = (ImageView) findViewById(R.id.img);
        img1 = (ImageView) findViewById(R.id.img1);
        pb= (ProgressBar) findViewById(R.id.pgb);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar s) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar s) {
            }

            @Override
            public void onProgressChanged(SeekBar s, int i, boolean b) {
               sb.setProgress(i);
//                Message m = new Message();
//                m.what = i;
//                h.handleMessage(m);
              img.setAlpha(i);
            }
        });
        (new Thread(){
            @Override
            public void run() {
                while (data<=100){
                    h.handleMessage(new Message());
                    data+=5;
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message m=new Message();
                m.what=0x99;
                h.sendMessage(m);
            }

        }).start();
              rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

           @Override
            public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
//               rb.setRating(arg1);
//                Message m = new Message();
//                m.what = (int)(arg1*255/5);
//                h.handleMessage(m);
               img.setAlpha((int)(arg1*255/5));

            }
        });

    }
}