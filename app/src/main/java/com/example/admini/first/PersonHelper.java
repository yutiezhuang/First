package com.example.admini.first;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/6/3.
 */
public class PersonHelper extends SQLiteOpenHelper {
//    public static final String CREATE_STUDNET_TABLE="create table Studnet(_id integer primary key,name varchar(50),pic integer,age integer)";
public static final String CREATE_STUDENT_TABLE = "create table person(_id integer primary key,name varchar(50),pic integer,age integer,skill varchar(50))";
    public PersonHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(CREATE_STUDENT_TABLE);
        ContentValues cv=new ContentValues();
        cv.put("_id",1);
        cv.put("name","嘉文四世");
        cv.put("pic",R.drawable.a02);
        cv.put("age",22);
        cv.put("skill","天崩地裂");
        db.insert("person",null,cv);
//        ContentValues cv1=new ContentValues();
//        cv.put("_id",2);
//        cv.put("name","凯特琳");
//        cv.put("pic",R.drawable.a03);
//        cv.put("age",20);
//        cv.put("skill","让子弹飞");
//        db.insert("person",null,cv1);
//        ContentValues cv2=new ContentValues();
//        cv.put("_id",3);
//        cv.put("name","李青");
//        cv.put("pic",R.drawable.a04);
//        cv.put("age",26);
//        cv.put("skill","神龙摆尾");
//        db.insert("person",null,cv2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
