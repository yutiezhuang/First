package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-5-18.
 */
public class A0_adapt extends BaseActivity {
        List<Studnet> list = new ArrayList<Studnet>();

        List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();
        @Override
        protected void initContentView(Bundle savedInstanceState) {
           // super.onCreate(savedInstanceState);
            setContentView(R.layout.a0_1adapt);

            Studnet s1 = new Studnet();
            Studnet s2 = new Studnet();
            Studnet s3 = new Studnet();
            Studnet s4 = new Studnet();
            Studnet s5 = new Studnet();

            s1.setName("关羽");
            s2.setName("张飞");
            s3.setName("赵云");
            s4.setName("马超");
            s5.setName("黄忠");
            s1.setAge(30);
            s2.setAge(28);
            s3.setAge(25);
            s4.setAge(29);
            s5.setAge(40);
            s1.setPic(R.drawable.gallerymin1);
            s2.setPic(R.drawable.gallerymin2);
            s3.setPic(R.drawable.gallerymin3);
            s4.setPic(R.drawable.gallerymin4);
            s5.setPic(R.drawable.gallerymin5);
            Collections.addAll(list,s1,s2,s3,s4,s5);


            for(Studnet ss:list)
            {
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("studName",ss.getName());
                map.put("studAge",ss.getAge());
                map.put("studPic",ss.getPic());

                res.add(map);
            }

            ListView view = (ListView) findViewById(R.id.studList);
//        SimpleAdapter sa = new SimpleAdapter(this,res,R.layout.ex09_row_layout,new String[]{"studName","studAge","studPic"},new int[]{R.id.studName,R.id.studAge,R.id.studPic});
//        view.setAdapter(sa);
            MyAdpater ad = new MyAdpater();
            view.setAdapter(ad);
        }

        class MyAdpater extends BaseAdapter
        {
            @Override
            public int getCount() {
                return res.size();
            }

            @Override
            public Object getItem(int position) {
                return res.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater li = LayoutInflater.from(A0_adapt.this);
                View view = li.inflate(R.layout.a0_adapt,null);

                ImageView iv = (ImageView) view.findViewById(R.id.studPic);
                TextView nameTv = (TextView) view.findViewById(R.id.studName);
                TextView ageTv = (TextView) view.findViewById(R.id.studAge);

                Map<String,Object> obj = res.get(position);
                iv.setImageResource((int) obj.get("studPic"));
                nameTv.setText((String) obj.get("studName"));
                ageTv.setText((int) obj.get("studAge")+"");

                return view;
            }
        }
    }

