package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 16-5-19.
 */
public class A0_2tu extends BaseActivity {
    int[] i={R.drawable.gallerymin1,R.drawable.gallerymin2,R.drawable.gallerymin3,R.drawable.gallerymin4,R.drawable.gallerymin5};

    AdapterViewFlipper adapterViewFlipper;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_2tu);
        adapterViewFlipper= (AdapterViewFlipper) findViewById(R.id.myadp);
        BaseAdapter b=new BaseAdapter() {
            @Override
            public int getCount() {
                return i.length;
            }

            @Override
            public Object getItem(int position) {
                return i[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView iv=new ImageView(A0_2tu.this);
                iv.setImageResource(i[position]);
                return iv;
            }
        };
        adapterViewFlipper.setAdapter(b);
        adapterViewFlipper.setFlipInterval(3000);
        adapterViewFlipper.startFlipping();
    }

    public void last(View s){

        adapterViewFlipper.showPrevious();
        adapterViewFlipper.stopFlipping();
    }
    public void next(View s){

        adapterViewFlipper.showNext();
        adapterViewFlipper.stopFlipping();
    }
    public void auto(View s){

        adapterViewFlipper.startFlipping();
    }
}
