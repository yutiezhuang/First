package com.example.admini.first;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import been.gupiao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class A0_52zuoye extends BaseActivity {
    EditText et1;
    EditText et2;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
       setContentView(R.layout.a0_52zuoye);
        et1= (EditText) findViewById(R.id.text);
        et2= (EditText) findViewById(R.id.text1);
    }
    public void find(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        A0_gupiao baidu = retrofit.create(A0_gupiao.class);
        Call<gupiao> call = baidu.getPhoneInfo("562bafef6007883e2e8fffbbdfa9e6ac",et1.getText().toString(),"0");

        call.enqueue(new Callback<gupiao>() {
            @Override
            public void onResponse(Call<gupiao> call, Response<gupiao> response) {
                gupiao pc = response.body();
                et2.setText("股票名称："+pc.getRetData().getStockinfo().getName());
// et2.setText(pc.getMarket().getShanghai()+""+pc.getMarket().getShenzhen()+""+pc.getMarket().getDJI()+""+pc.getMarket().getHSI()+""+pc.getMarket().getINX()+""+pc.getMarket().getIXIC());
            }

            @Override
            public void onFailure(Call<gupiao> call, Throwable t) {

            }
        });
    }
}
