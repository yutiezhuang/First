package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/5/27.
 */
public class A2_12Activity extends BaseActivity {
  Handler h=new Handler(){
      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);
          if(msg.what==0){
              button.setText("获取验证码.");
              button.setEnabled(true);
              timer.cancel();
          }else {
              button.setText("获取中..."+msg.what+"秒");
          }
      }
  };

    Timer timer;
    Button button;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_12layout);
        button= (Button) findViewById(R.id.btn1);
    }
    public void send(View view){
        button.setEnabled(false);
        button.setText("获取验证码中......");
        timer =new Timer();
        timer.schedule(new TimerTask() {
            int time= 5;
            @Override
            public void run() {
                Message message=new Message();
                message.what=time--;
                h.sendMessage(message);
            }
        },100,1000);
    }
}
