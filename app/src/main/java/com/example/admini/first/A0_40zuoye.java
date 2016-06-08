package com.example.admini.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/7.
 */
public class A0_40zuoye extends Activity implements A0_40zuoye3.Callback {
    boolean twoPan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_40zuoye1);

        if(findViewById(R.id.book_detail_container)!=null)
        {
            twoPan = true;
        }
    }
    @Override
    public void onItemSelected(Integer id) {
        if(twoPan)
        {
            Bundle b = new Bundle();
            b.putInt("item_id",id);

            A0_40zuoye2 f = new A0_40zuoye2();
            f.setArguments(b);

            getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
        }else{
            Intent i = new Intent(this,A0_40zuoye1.class);
            i.putExtra("item_id",id);
            startActivity(i);
        }
    }

}
