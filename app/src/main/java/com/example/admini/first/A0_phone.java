package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 16-5-18.
 */
public class A0_phone extends BaseActivity {
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b=msg.getData();
            String str= (String) b.get("str");
           Gson a=new Gson ();
            PhoneCity pc = a.fromJson(str,PhoneCity.class);
            if("success".equals(pc.getRetMsg()))
            {
                result.setText(pc.getRetData().getProvince()+"省"+pc.getRetData().getCity()+"市"+pc.getRetData().getSupplier());
            }else {
                result.setText("未查询到！");
            }
        }


    };
    EditText phone;
    TextView result;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_phone);
        phone = (EditText) findViewById(R.id.phone);
        result = (TextView) findViewById(R.id.result);
    }
    public void phonefind(View view){
        (new Thread(){
            @Override
            public void run() {
                String httpurl = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber";
                BufferedReader reader=null;
                String result=null;
                StringBuffer sb=new StringBuffer();
                httpurl = httpurl+"?phone="+phone.getText().toString();
                try {
                    URL url = new URL(httpurl);
                    HttpURLConnection Connection= (HttpURLConnection) url.openConnection();
                    Connection.setRequestMethod("GET");
                    Connection.setRequestProperty("apikey","562bafef6007883e2e8fffbbdfa9e6ac");
                    Connection.connect();
                    InputStream is=Connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                    String Read=null;
                    while ((Read=reader.readLine())!=null){
                       sb.append(Read);
                        sb.append("\r\n");

                    }
                    reader.close();
                    result=sb.toString();
                    Message m = new Message();
                    Bundle b = new Bundle();
                    b.putSerializable("str",result);
                    m.setData(b);
                    h.sendMessage(m);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
