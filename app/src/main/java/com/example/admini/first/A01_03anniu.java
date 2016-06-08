package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Administrator on 16-5-24.
 */
public class A01_03anniu extends BaseActivity {
    RadioButton rb1;
    RadioButton rb2;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    Button b;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        // super.onCreate(savedInstanceState);
        setContentView(R.layout.a01_03anniu);

    }
}
//    public void show(){
//       rb1= (RadioButton) findViewById(R.id.btn1);
//        rb2= (RadioButton) findViewById(R.id.btn2);
//        cb1= (CheckBox) findViewById(R.id.button1);
//        cb2= (CheckBox) findViewById(R.id.button2);
//        cb3= (CheckBox) findViewById(R.id.button3);
//        cb4= (CheckBox) findViewById(R.id.button4);
//        b= (Button) findViewById(R.id.btn3);
//        Toast.makeText(A01_03anniu.this,rb1.getText()+","+rb2.getText()+","+cb1.getText()+","+cb2.getText()+","+cb3.getText()+","+cb4.getText(), Toast.LENGTH_SHORT).show();
//
//    }

