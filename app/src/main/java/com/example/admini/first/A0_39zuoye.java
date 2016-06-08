package com.example.admini.first;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;

import java.util.List;

/**
 * Created by Administrator on 2016/6/7.
 */
public class A0_39zuoye extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hasHeaders()) {
            Button button = new Button(this);
            button.setText("保存设置");
            setListFooter(button);
        }
    }
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers,target);
    }
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }

public static class Prefs1Fragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载一个布局文件
        addPreferencesFromResource(R.xml.preferences);
    }
}
    public static class Prefs2Fragment extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //加载一个布局
            addPreferencesFromResource(R.xml.display_prefs);
        }
    }
}
