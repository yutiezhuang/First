package com.example.admini.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Administrator on 2016/5/26.
 */
public abstract class BaseActivity extends AppCompatActivity {

    AlertDialog ad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.normal_btn:
                        AlertDialog.Builder adb=new AlertDialog.Builder(BaseActivity.this);
                        adb.setTitle("～～制作者～～");
                        adb.setMessage("～～于铁桩～～");
                        adb.create().show();
                        break;
                    case R.id.normal_btn1:
                        Intent i1=new Intent(BaseActivity.this,A0_39zuoye.class);
                        startActivity(i1);
                        break;
                }
                return true;
            }
        });
        getSupportActionBar().setTitle("柠檬ぃ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

   public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inf = new MenuInflater(this);
        inf.inflate(R.menu.basemenu,menu);
        return super.onCreateOptionsMenu(menu);
   }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent i=new Intent(this,HomeWork.class);
                startActivity(i);
//                if(){
//                    Toast.makeText(this, "对不起已经最后一页", Toast.LENGTH_SHORT).show();
//                }
                break;

        }
        return true;
    }

    protected abstract void initContentView(Bundle savedInstanceState);
   }

