package com.example.admini.first;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 16-5-13.
 */
public class qq extends BaseActivity {
    SharedPreferences sp;

    SharedPreferences.Editor editor;

    EditText name;
    EditText psd;
    String un="admin";
    String pw="123";
    String un1="nihao";
    String pw1="234";
    CheckBox ch1;
    CheckBox ch2;
    boolean flag=false;
       @Override
    public void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.qq);
           name= (EditText) findViewById(R.id.text1);
           psd= (EditText) findViewById(R.id.text2);
           ch1= (CheckBox) findViewById(R.id.check1);
           ch2= (CheckBox) findViewById(R.id.check2);
           sp= PreferenceManager.getDefaultSharedPreferences(this);
          ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  flag=isChecked;
              }
          });
           sp = getSharedPreferences("login",MODE_PRIVATE);
           editor = sp.edit();
           boolean b = sp.getBoolean("auto",false);
           if(b){
               Intent i=new Intent(this,zuoye14Activity.class);
               startActivity(i);
           }
       }
    public void denglu(View view){
        //Toast.makeText(qq.this, "好使", Toast.LENGTH_SHORT).show();
//        editor.putString("name", String.valueOf(et1.getText()));
//        editor.putString("psd",String.valueOf(et2.getText()));
//        editor.putBoolean("ch1",true);
//        editor.putBoolean("ch2",true);
//        editor.commit();
        if(name.getText().toString().equals(un)&&psd.getText().toString().equals(pw)){
            editor.putBoolean("auto",flag);
            editor.commit();
            Intent i=new Intent(this,zuoye14Activity.class);
            startActivity(i);
    }else if (name.getText().toString().equals(un1)&&psd.getText().toString().equals(pw1)){
            editor.putBoolean("auto",flag);
            editor.commit();
            Intent i=new Intent(this,heart.class);
            startActivity(i);
        }else {
            Toast.makeText(qq.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}
