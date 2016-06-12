package com.example.admini.first;

import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2016/6/12.
 */
public class A0_53zuoye extends BaseActivity {
    EditText xuehao;
    EditText sname;
    EditText birth;
    EditText path;
    Button but;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_53zuoye);
        xuehao= (EditText) findViewById(R.id.xuehao);
        sname= (EditText) findViewById(R.id.name);
        birth= (EditText) findViewById(R.id.shengri);
        path= (EditText) findViewById(R.id.image);
        path.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(A0_53zuoye.this,A0_54zuoye.class);
                startActivityForResult(i,0);
            }
        });
        but= (Button) findViewById(R.id.btn);
    }
    public  void chuan(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.188:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        A0_53xuesheng xs=retrofit.create(A0_53xuesheng.class);
        File file=new File(path.getText().toString());
        RequestBody requestBody=RequestBody.create(MediaType.parse("multipart/form-data"),file);
        Call<Message> call=xs.uploadStudentInfo(xuehao.getText().toString(),sname.getText().toString(),birth.getText().toString(),file.getName(),requestBody);
        call.enqueue(new Callback<Message>() {
          @Override
          public void onResponse(Call<Message> call, Response<Message> response) {
              Message m=response.body();
          }

          @Override
          public void onFailure(Call<Message> call, Throwable t) {
            Log.e("we",t.getMessage());
          }
      });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 123){
            String birth = data.getStringExtra("birth");
            path.setText(birth);
        }
    }
}
