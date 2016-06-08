package com.example.admini.first;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class A01_4Activity extends BaseActivity {
    List<String> list=new ArrayList<String>();
    TextView tv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.a01_4layout);
    }
    public void send(View view){
       final String [] str={"吃","喝","骑车","跑步","篮球","做饭"};
        tv= (TextView) findViewById(R.id.text);
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("简单的对话框");
        b.setIcon(R.drawable.avatar2);
        b.setMultiChoiceItems(str, new boolean[str.length], new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    list.add(str[which]);
                }else {
                    list.remove(str[which]);
                }
            }
        });
        b.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText(list.toString());
                list.clear();
            }
        });
        b.create().show();
    }
}
