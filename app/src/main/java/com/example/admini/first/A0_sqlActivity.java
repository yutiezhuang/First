package com.example.admini.first;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Administrator on 2016/6/3.
 */
public class A0_sqlActivity extends BaseActivity {
//    PersonHelper ph;
//    ListView lv;
//    @Override
//    protected void initContentView(Bundle savedInstanceState) {
//        setContentView(R.layout.a0_sqlzuoye);
//        lv= (ListView) findViewById(R.id.list);
//        ph=new PersonHelper(this,"person.db",null,con);
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.a0_sqlzuoye);
//        ph=new PersonHelper(this,"person.db",null,Contants.DB_VERSION);
//        lv= (ListView) findViewById(R.id.listview);
//
//
//        Cursor c = ph.getReadableDatabase().query("person",null,null,null,null,null,null);
//        SimpleCursorAdapter sca=new SimpleCursorAdapter(this,R.layout.a0_sqlzuoye1,c,new String[]{"name","pic","age","skill"},new int[]{R.id.name,R.id.pic,R.id.age,R.id.skill},0);
//        lv.setAdapter(sca);
//        SimpleCursorAdapter sca=new SimpleCursorAdapter(this,R.layout.a0_adapt,c,new String[]{"name","pic","age"},new int[]{R.id.studName,R.id.studPic,R.id.studAge},0);
//        lv.setAdapter(sca);
    StudentHelper helper;
    ListView lv;
    Button button;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_sqlzuoye);

        helper = new StudentHelper(this,"student.db",null,Contants.DB_VERSION);
        lv = (ListView) findViewById(R.id.listview);
        button= (Button) findViewById(R.id.btn);

        Cursor c = helper.getReadableDatabase().query("student",null,null,null,null,null,null);
        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.a0_sqlzuoye1,c,new String[]{"name","pic","age"},new int[]{R.id.studName,R.id.studPic,R.id.studAge},0);

        lv.setAdapter(aca);

    }
}
