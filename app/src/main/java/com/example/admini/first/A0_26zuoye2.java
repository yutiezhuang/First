package com.example.admini.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

/**
 * Created by Administrator on 2016/5/31.
 */
public class A0_26zuoye2 extends BaseActivity {
    CalendarView cv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_26zuoye2);
        cv= (CalendarView) findViewById(R.id.calendar);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Intent i=getIntent();
                i.putExtra("shengri","你的生日是"+year+"年"+(month+1)+"月"+dayOfMonth+"日");
                setResult(123,i);
                finish();
            }
        });
    }
}
