package com.example.admini.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/6/2.
 */
public class A0_file extends BaseActivity {
    EditText et;
    Button button;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_file);
        et= (EditText) findViewById(R.id.text);
        button= (Button) findViewById(R.id.btn);

    }
    public void xiazai(View view){

    }
}
