package com.example.admini.first;

import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/13.
 */
public class A0_56zuoye1 extends BaseActivity {
    ShakeListener mShakeListener = null;
    private TextView tv;
    private ImageView iv;
    Vibrator vibrator;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
                // TODO Auto-generated method stub
               // super.onCreate(savedInstanceState);
                this.setContentView(R.layout.a0_56zuoye);

                tv=(TextView)this.findViewById(R.id.text);
                iv=(ImageView)this.findViewById(R.id.image);

                mShakeListener = new ShakeListener(this);
                mShakeListener.setOnShakeListener(new shakeLitener());
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);

            }
            private class shakeLitener implements ShakeListener.OnShakeListener {
                @Override
                public void onShake() {
                    // TODO Auto-generated method stub
                    //tv.setText("摇一摇成功啦！");
                    //iv.setImageResource(R.drawable.icon_11);
                    Toast.makeText(A0_56zuoye1.this, "对不起没有一起摇一摇的人", Toast.LENGTH_LONG).show();
                    mShakeListener.stop();
                    vibrator.vibrate(1000);
                }

            }
        }

