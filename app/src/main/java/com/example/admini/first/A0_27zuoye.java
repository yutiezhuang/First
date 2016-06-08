package com.example.admini.first;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/1.
 */
public class A0_27zuoye extends BaseActivity {
    int[] imgs = {R.drawable.icon_11,R.drawable.icon_13,R.drawable.icon_16,R.drawable.icon_18,
            R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_31,R.drawable.icon_33,R.drawable.icon_34,
            R.drawable.icon_37,R.drawable.icon_40,R.drawable.icon_41};
    List<Map<String ,Object>> list = new ArrayList<Map<String , Object>>();
    @Override
    protected void initContentView(Bundle savedInstanceState) {
      setContentView(R.layout.a0_27zuoye);
        GridView gv= (GridView) findViewById(R.id.grid);
        for (int i=0;i<imgs.length;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("id",imgs[i]);
            list.add(map);
        }
        SimpleAdapter sa=new SimpleAdapter(this,list,R.layout.a0_27zuoye2,new String[]{"id"},new int []{R.id.image});
        gv.setAdapter(sa);
    }
}
