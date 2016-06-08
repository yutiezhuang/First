package com.example.admini.first;

import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MainActivity extends BaseActivity {
//      EditText et= (EditText) findViewById(R.id.text1);
    @Override
    protected void initContentView(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DisplayMetrics dm=new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int width=dm.widthPixels;
//        int height=dm.heightPixels;
//        float density=dm.density;
//        int densityDpi=dm.densityDpi;
//        et.setText(width+","+height+","+density+","+densityDpi);

    }

    public void mybuttonClick(View view){
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str=sdf.format(d);

        TextView tv= (TextView) findViewById(R.id.editText);
        tv.setText(str);
    }
    public void show(View view){
        String a="朱晓琳是2B么";
        TextView tv= (TextView) findViewById(R.id.editText);
        tv.setText(a);
    }
    public void show1(View view){
        String b="是的";
        TextView tv= (TextView) findViewById(R.id.editText);
        tv.setText(b);
    }
    public void show2(View view){
        String c="Hello World!";
        TextView tv= (TextView) findViewById(R.id.editText);
        tv.setText(c);
    }
}
