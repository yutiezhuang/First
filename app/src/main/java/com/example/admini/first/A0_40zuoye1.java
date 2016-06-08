package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/7.
 */
public class A0_40zuoye1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_40zuoye3);

        if(savedInstanceState == null)
        {
            A0_40zuoye2 f = new A0_40zuoye2();
            Bundle b = new Bundle();
            b.putInt("item_id",getIntent().getIntExtra("item_id",0));
            f.setArguments(b);

            getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
        }
    }
}
