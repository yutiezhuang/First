package com.example.admini.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/5/25.
 */
public class HomeWork extends BaseActivity {
    String[] s={"作业1：字：图片","作业2：分辨率","作业3：图片循环","作业4：心连心","作业5：布局","作业6：QQ布局","作业7：用户登录布局","作业8：霓虹灯","作业9：中心十字","作业10：计算器"
            ,"作业11：搜索内容布局","作业12：Radio布局", "作业13：验证码","作业14：下拉菜单","作业15：图片自动播放","作业16：图片透明度","作业17：ListView展示","作业18：搜索框展示","作业19：选项卡","作业20：选中显示内容"
            ,"作业21：弹出框练习","作业22：联机菜单传参","作业23：飞机拖动","作业24：点击跳转电话","作业25：手机归属地","作业26：选择生日","作业27：多行GRIDVIEW","作业28：帧动画","作业29：画板","作业30：飞机大战"
    ,"作业31：进度条隐藏图片，评星","作业32：查询联系人信息","作业33：跳转百度","作业34：按钮跳百度跳主界面","作业35：弹球游戏","作业36：SQL语句练习","作业37：百度语音朗读","作业38：手势控制图片","作业40：图书Fragment"
    ,"作业41：语言改变","作业42：手势保存","作业43：验证识别手势","作业44：音乐播放","作业45：手势滑动控制图片放缩","作业46：视频播放","作业47：来电监听","作业48：音频录制","作业49：短信发送","作业50：视频录制"
   ,"作业51：震动","作业52：闹钟","作业53:MediaPlayer和SurfaceView播放视频","作业54：Retrofit股票查询","作业55：上传数据到服务器","作业56：指南针","作业57：摇一摇","百度地图","标记位置"};
    Class [] classzz={MainActivity.class,A0_02Activity.class,A0_04Activiy.class,heart.class,text1.class,qq.class,Biaoge.class,wuse.class,xiangdui.class,A0_pic.class
            ,A0_sou.class,A01_03anniu.class,A2_12Activity.class,zuoye14Activity.class,A0_2tu.class,A0_tu.class,A0_adapt.class,A01_2Activity.class,A0_xuanxiangka.class,A0_xueli.class
            ,A01_4Activity.class,A0_22zuoye.class,Feiji.class,A0_24zuoye.class,A0_phone.class,A0_26zuoye.class,A0_27zuoye.class,A0_28zuoye.class,A0_29zuoye.class,PlaneActivity.class
            ,A01_ProgressBar.class,A0_32zuoye.class,A0_33zuoye.class,A0_34zuoye.class,ballActivity.class,A0_sqlActivity.class,A0_37zuoye.class,A0_38zuoye.class,Ex30Activity.class
            ,A0_41zuoye.class,A0_42zuoye.class,A0_43zuoye.class,A0_44zuoye.class,A0_45zuoye.class,A0_46shipin.class,A0_47zuoye.class,A0_48zuoye.class,A0_49zuoye.class,A0_50zuoye.class
            ,A0_zhendong.class,A0_naozhong.class,A0_51zuoye.class,A0_52zuoye.class,A0_53zuoye.class,A0_55zuoye.class,A0_56zuoye1.class,Ex58Activity.class,A0_57zuoye.class};

    ListView lv;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, s);
        lv = (ListView) findViewById(R.id.listid);

        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(HomeWork.this,classzz[position]);
                startActivity(i);
            }
        });
    }
}
