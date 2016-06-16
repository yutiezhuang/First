package com.example.admini.first;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Window;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

/**
 * Created by 果占先 on 2016/6/16.
 */
public class Ex58Activity extends Activity {
    MapView map;
//    BaiduMap bmap;
//    LocationManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ex58_layout);
        map = (MapView) findViewById(R.id.mymap);
//        bmap=map.getMap();
//        bmap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }
}
