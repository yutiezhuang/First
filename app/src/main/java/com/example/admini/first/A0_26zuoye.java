package com.example.admini.first;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/5/31.
 */
public class A0_26zuoye extends BaseActivity {
    EditText et;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_26zuoye);
        et= (EditText) findViewById(R.id.text);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(A0_26zuoye.this,A0_26zuoye2.class);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0){
            String sheng=data.getStringExtra("shengri");
            et.setTextSize(24);
            et.setTextColor(Color.BLUE);
            et.setText(sheng);
        }
    }
}
