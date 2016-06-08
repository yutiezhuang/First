package com.example.admini.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/6/7.
 */
public class A0_44zuoye extends BaseActivity {

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_44zuoye);

    }
    public void startPlay(View view)
    {
        Intent i = new Intent(this,A0_44Service.class);
        startService(i);
    }

    public void stopPlay(View view)
    {
        Intent i = new Intent(this,A0_44Service.class);
        stopService(i);
    }
}
