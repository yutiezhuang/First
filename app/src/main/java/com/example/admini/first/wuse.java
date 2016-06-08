package com.example.admini.first;

/**
 * Created by Administrator on 16-5-16.
 */
        import java.util.Timer;
        import java.util.TimerTask;
        import android.app.Activity;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.Message;
        import android.widget.FrameLayout;

public class wuse extends BaseActivity{

    int[] a = { R.id.se1, R.id.se2, R.id.se3, R.id.se4, R.id.se5};
    int[] color = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.DKGRAY};
    Timer t ;
    int b = 0;

    Handler h =
            new Handler(){
        public void handleMessage(Message msg) {
            for(int i=0;i<5;i++){
                FrameLayout fl = (FrameLayout)findViewById(a[i]);
                fl.setBackgroundColor(color[(msg.what+i)%5]);
            }
        };
    };
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.duocai);
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                b++;
                Message m = new Message();
                m.what = b;
                h.sendMessage(m);
            }
        }, 100,100);
    }
}

