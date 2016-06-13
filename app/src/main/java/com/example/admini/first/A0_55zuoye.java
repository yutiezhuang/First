package com.example.admini.first;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/13.
 */
public class A0_55zuoye extends BaseActivity implements SensorEventListener{
    // 定义显示指南针的图片
    ImageView znzImage;
    // 记录指南针图片转过的角度
    float currentDegree = 0f;
    // 定义真机的Sensor管理器
    SensorManager mSensorManager;


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        System.out.println("MainActivity.onCreate()");
        setContentView(R.layout.a0_55zuoye);
        // 获取界面中显示指南针的图片
        znzImage = (ImageView) findViewById(R.id.image);

        // 获取真机的传感器管理服务
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity.onResume()");
        // 为系统的方向传感器注册监听器
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        System.out.println("MainActivity.onPause()");
        // 取消注册
        mSensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("MainActivity.onStop()");
        // 取消注册
        mSensorManager.unregisterListener(this);
        super.onStop();
    }
    public void onSensorChanged(SensorEvent event) {
        System.out.println("MainActivity.onSensorChanged()");
        // 真机上获取触发event的传感器类型
        int sensorType = event.sensor.getType();
        // 模拟器上获取触发event的传感器类型
        switch (sensorType) {
            case Sensor.TYPE_ORIENTATION:
                // 获取绕Z轴转过的角度。
                float degree = event.values[0];
                // 创建旋转动画（反向转过degree度）
                RotateAnimation ra = new RotateAnimation(currentDegree, -degree,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                // 设置动画的持续时间
                ra.setDuration(200);
                // 运行动画
                znzImage.startAnimation(ra);
                currentDegree = -degree;
                break;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        System.out.println("MainActivity.onAccuracyChanged()");
    }
}