package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.AndroidCharacter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 16-5-18.
 */
public class A0_3zuoye extends Activity {
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b=msg.getData();
            String str= (String) b.get("str");
            Gson g=new Gson();

            // PhoneCitypc = g.fromJson(str,PhoneCity.class);
            A0_xinwen a=g.fromJson(str,A0_xinwen.class);
            if("ok".equals(a.getMsg()))
           {
               List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
               List<A0_xinwen.NewslistBean> l=a.getNewslist();
               for(A0_xinwen.NewslistBean ax:l){
                   Map<String,Object> m=new HashMap<String,Object>();
                   m.put("ctime",ax.getCtime());
                   m.put("description",ax.getDescription());
                   m.put("picURL",ax.getPicUrl());
                   m.put("title",ax.getTitle());
                   m.put("URL",ax.getUrl());
                   list.add(m);
               }
               SimpleAdapter sa=new SimpleAdapter(A0_3zuoye.this,list,R.layout.a0_3zuoye1,new String[]{"ctime","description","picURL","title","URL"}
                       ,new int[]{R.id.text1,R.id.text2,R.id.text3,R.id.text4,R.id.text5});
                      lv.setAdapter(sa);

//                text1.setText(a.getClass());
            }

        }
    };

    ListView lv= (ListView) findViewById(R.id.list1id);
    TextView text1= (TextView) findViewById(R.id.text1);
    TextView text2= (TextView) findViewById(R.id.text2);
    TextView text3= (TextView) findViewById(R.id.text3);
    TextView text4= (TextView) findViewById(R.id.text4);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final A0_xinwen aa=new A0_xinwen();
        setContentView(R.layout.a0_3zuoye);


        (new Thread(){
            @Override
            public void run() {
                String httpurl = "http://apis.baidu.com/txapi/apple/apple";
                BufferedReader reader=null;
                String result=null;
                StringBuffer sb=new StringBuffer();
                //httpurl = httpurl+"?phone="+phone.getText().toString();
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
