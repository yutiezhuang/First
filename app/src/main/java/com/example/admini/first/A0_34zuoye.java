package com.example.admini.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/6/2.
 */
public class A0_34zuoye extends Activity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_34zuoye);
    }


//    @Override
//    protected void initContentView(Bundle savedInstanceState) {
//        setContentView(R.layout.a0_34zuoye);
//    }
    public void dianji1(View view){
        i=new Intent();
        i.setAction(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        startActivity(i);
    }
    public void dianji2(View view){
        i=new Intent(A0_34zuoye.this,A0_33zuoye.class);
        startActivity(i);
    }
}
