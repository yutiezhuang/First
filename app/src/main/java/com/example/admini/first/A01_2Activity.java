package com.example.admini.first;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

/**
 * Created by Administrator on 16-5-24.
 */
public class A01_2Activity extends BaseActivity {
    String[] str;
    SearchView sv1;
    ListView lv;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.a01_2layout);
        sv1= (SearchView) findViewById(R.id.sv);
        lv= (ListView) findViewById(R.id.list);
        str=new String[]{"aaa","bbb","abd","abc","acd","abc","cba","bdb","aba","bbc","bdc"};
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,str);
        lv.setAdapter(aa);
        lv.setTextFilterEnabled(true);
       lv.setVisibility(View.GONE);
        sv1.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()!=0){
                    lv.setFilterText(newText);
                   lv.setVisibility(View.VISIBLE);
                }else {
                    lv.clearTextFilter();
                    lv.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });
    }
}
