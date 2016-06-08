package com.example.admini.first;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/5/31.
 */
public class A0_22zuoye extends BaseActivity {
    EditText et;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_22zuoye);
        et= (EditText) findViewById(R.id.city);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(A0_22zuoye.this,A0_22zuoye2.class);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==123){
            String city=data.getStringExtra("city");
            et.setTextSize(24);
            et.setTextColor(Color.BLUE);
            et.setText(city);
        }
    }
}
