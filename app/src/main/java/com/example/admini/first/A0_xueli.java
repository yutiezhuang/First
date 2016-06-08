package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Administrator on 16-5-19.
 */
public class A0_xueli extends BaseActivity {
    String [] s={"高中","专科","本科","研究生","硕士"};

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_xueli);
        Spinner ss= (Spinner) findViewById(R.id.xiala);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        ss.setAdapter(aa);
        ss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String t="你选择的是"+s[position];
                Toast.makeText(A0_xueli.this,t , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
