package com.example.admini.first;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 16-5-13.
 */
public class ballActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.admini.first.ballview a=new com.example.admini.first.ballview(this);
       a.setOnTouchListener(a);
        setContentView(a);
    }
    //    float cx=0;
//    float ax=0;
//    float dx=0;
//    private int tablewidth;
//    private int tabkeheight;
//    private int racketY;
//    private final int RACKET_HEIGHT=20;
//    private final int RACKET_WIDTH=120;
//    private final int BALL_SIZE=12;
//    private int ySpeed=20;
//    Random rand=new Random();
//    private double xyRate=rand.nextDouble()-0.5;
//    private int xSpeed=(int)(ySpeed*xyRate*4);
//    private int ballX=rand.nextInt(200)+20;
//    private int ballY=rand.nextInt(10)+20;
//    private int racketX=rand.nextInt(200);
//    private boolean isLose=false;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        final GameView gameView = new GameView(this);
//        setContentView(gameView);
//        WindowManager WindowManager = getWindowManager();
//        Display display = WindowManager.getDefaultDisplay();
//        tablewidth = display.getWidth();
//        tabkeheight = display.getHeight();
//        racketY = tabkeheight - 80;
//        final Handler handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                if (msg.what == 0x123) {
//                    gameView.invalidate();
//                }
//
//            }
//        };
//        gameView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                switch (event.getKeyCode()) {
//                    case KeyEvent.KEYCODE_DPAD_LEFT:
//                        if (racketX > 0) {
//                            racketX -= 50;
//                            break;
//                        }
//                    case KeyEvent.KEYCODE_DPAD_RIGHT:
//                        if (racketX < tablewidth - RACKET_WIDTH) {
//                            racketX += 50;
//                            break;
//                        }
//                }
//                        gameView.invalidate();
//                        return true;
//                }
//        });
//
//        final Timer timer=new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if (ballX<=0||ballX>=tablewidth-BALL_SIZE){
//                       xSpeed=-xSpeed;
//                }
//                if(ballY>=racketY-BALL_SIZE&&(ballX<racketX||ballX>racketX+RACKET_WIDTH)){
//                        timer.cancel();
//                    isLose=true;
//                }else if(ballY<=0||(ballY>=racketY-BALL_SIZE&&ballX>racketX&&ballX<=racketX+RACKET_WIDTH)){
//                        ySpeed=-ySpeed;
//                }
//                ballY+=ySpeed;
//                ballX+=xSpeed;
//                handler.sendEmptyMessage(0x123);
//            }
//        },0,100);
//    }
//        class GameView extends View {
//            public GameView(Context context) {
//                super(context);
//                setFocusable(true);
//            }
//
//            @Override
//            protected void onDraw(Canvas canvas) {
//                Paint paint=new Paint();
//                paint.setStyle(Paint.Style.FILL);
//                if(isLose){
//                  paint.setColor(Color.RED);
//                    paint.setTextSize(40);
//                    canvas.drawText("游戏结束",50,200,paint);
//                }else{
//                    paint.setColor(Color.rgb(240,240,80));
//                    canvas.drawCircle(ballX,ballY,BALL_SIZE,paint);
//                    paint.setColor(Color.rgb(80,80,200));
//                    canvas.drawRect(racketX,racketY,racketX+RACKET_WIDTH,racketY+RACKET_HEIGHT,paint);
//                }
//            }
//        }
//
}
