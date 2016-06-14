package com.example.admini.first;

/**
 * Created by Administrator on 2016/6/14.
 */
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class A0_zhendong extends BaseActivity {
    Vibrator vibrator;
    long[] zhen={200,300,400,700,1000};
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_zhendong);
        vibrator= (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
    }
    public void kaishizhen(View view){
        vibrator.vibrate(zhen,0);
    }
    public void tingzhizhen(View view){
        vibrator.cancel();
    }
}
