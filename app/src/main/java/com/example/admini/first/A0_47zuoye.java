package com.example.admini.first;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by Administrator on 2016/6/8.
 */
public class A0_47zuoye extends BaseActivity {
    TelephonyManager telManager;
    MediaPlayer mp;
    SpeechSynthesizer speechSynthesizer;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_47zuoye);
        telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("7934301");
        speechSynthesizer.setApiKey("mF30Ge9lZS6q1ClMrYMczr3tVnOxP7P1", "Ci0K4l51f9trzM5Ku2shpLf2MriiaWq7");
        speechSynthesizer.initTts(TtsMode.ONLINE);
        mp = MediaPlayer.create(this,R.raw.wish);
        PhoneStateListener listener = new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch (state)
                {
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        speechSynthesizer.speak("你挂了");
                        Toast.makeText(A0_47zuoye.this, "挂断", Toast.LENGTH_SHORT).show();
                        mp.stop();
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        speechSynthesizer.speak(incomingNumber+"来电话了！");
                        Toast.makeText(A0_47zuoye.this, incomingNumber, Toast.LENGTH_LONG).show();
                        mp.start();
                        break;
                    default:
                        break;
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };

        telManager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }

}
