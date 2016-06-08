package com.example.admini.first;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 果占先 on 2016/6/3.
 */
public class StudentHelper extends SQLiteOpenHelper {

    public static final String CREATE_STUDENT_TABLE = "create table student(_id integer primary key,name varchar(50),pic integer,age integer)";

    public StudentHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
        ContentValues c = new ContentValues();
//        c.put("_id",1);
//        c.put("name","嘉文四世");
//        c.put("pic",R.drawable.a02);
//        c.put("age",24);
        c.put("_id",2);
        c.put("name","凯特琳");
        c.put("pic",R.drawable.a03);
        c.put("age",20);
        db.insert("student",null,c);


//        db.insert("person",null,cv1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
