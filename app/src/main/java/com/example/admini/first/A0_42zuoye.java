package com.example.admini.first;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/7.
 */
public class A0_42zuoye extends BaseActivity {
    GestureOverlayView gestureView;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_42zuoye);
        gestureView = (GestureOverlayView) findViewById(R.id.gestureView);
        gestureView.setGestureColor(Color.GREEN);
        gestureView.setGestureStrokeWidth(5);
        gestureView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, final Gesture gesture) {
                View view = getLayoutInflater().inflate(R.layout.ex40_gesture_dialog,null);
                ImageView iv = (ImageView) view.findViewById(R.id.gestureImg);
                final EditText txt = (EditText) view.findViewById(R.id.gestureName);

                Bitmap bitmap = gesture.toBitmap(128,128,15,Color.BLUE);
                iv.setImageBitmap(bitmap);

                new AlertDialog.Builder(A0_42zuoye.this)
                        .setView(view)
                        .setPositiveButton("保存手势", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GestureLibrary gestlib = GestureLibraries.fromPrivateFile(A0_42zuoye.this,"mygestures");
                                gestlib.addGesture(txt.getText().toString(),gesture);
                                gestlib.save();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create().show();
            }
        });
    }
}
