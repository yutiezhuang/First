package com.example.admini.first;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by Administrator on 2016/6/6.
 */
public class A0_37zuoye extends BaseActivity {
    EditText et;
    SpeechSynthesizer speechSynthesizer;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_37zuoye);
        et= (EditText) findViewById(R.id.text);
        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("7934301");
        speechSynthesizer.setApiKey("mF30Ge9lZS6q1ClMrYMczr3tVnOxP7P1", "Ci0K4l51f9trzM5Ku2shpLf2MriiaWq7");
        speechSynthesizer.initTts(TtsMode.ONLINE);
    }
    public void playSound(View view) {
        speechSynthesizer.speak(et.getText().toString());
    }
}
