package com.example.admini.first;

import android.os.Bundle;
import android.widget.QuickContactBadge;

/**
 * Created by Administrator on 2016/5/31.
 */
public class A0_24zuoye extends BaseActivity {
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_24zuoye);
        QuickContactBadge qc= (QuickContactBadge) findViewById(R.id.quickContactBadge);
        qc.assignContactFromPhone("18888888888",false);
    }
}
