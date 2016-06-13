package com.example.admini.first;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Environment;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.EOFException;
        import java.io.File;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

/**
 * Created by Administrator on 2016/6/3.
 */
public class A0_54zuoye1 extends BaseActivity{

    ListView lv ;
    TextView tv;

    File root;
    File currentFather;
    File[] currentFile;
    Button button;


    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.a0_54zuoye);
        tv = (TextView) findViewById(R.id.layout_sd_tv1);
        lv = (ListView) findViewById(R.id.layout_sd_lv1);
        button = (Button) findViewById(R.id.layout_sd_btn1);
        try{
            root = new File("/mnt/sdcard/");
        }catch(Exception e){

        }

        if(root.exists()){
            Log.e("2222",root.getAbsolutePath());
            currentFather = root;
            currentFile = root.listFiles();
            Log.e("2222",currentFile+"");
            inflateListView(currentFile);
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentFile[position].isFile()){
                    try{
                        if(currentFile[position].getCanonicalPath().toString().contains(".png")){
                            Intent i = new Intent();
                            i.setAction(android.content.Intent.ACTION_VIEW);
                            i.setDataAndType(Uri.fromFile(currentFile[position]), "image/*");
                            startActivity(i);
                        }else if(currentFile[position].getCanonicalPath().toString().contains(".mp4")){
                            Intent i = new Intent();
                            i.setAction(android.content.Intent.ACTION_VIEW);
                            i.setDataAndType(Uri.fromFile(currentFile[position]), "vedio/*");
                            startActivity(i);
                        }
                    }catch(Exception e){

                    }

                    return ;
                }
                File[] temp = currentFile[position].listFiles();
                if(temp == null || temp.length == 0){
                    Toast.makeText(A0_54zuoye1.this, "当前路径不可访问或者没有文件", Toast.LENGTH_SHORT).show();
                }else{
                    currentFather = currentFile[position];
                    currentFile = temp;
                    inflateListView(currentFile);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(!currentFather.getCanonicalFile().equals(Environment.getExternalStorageDirectory().getCanonicalPath())){
                        currentFather = currentFather.getParentFile();
                        currentFile = currentFather.listFiles();
                        inflateListView(currentFile);
                    }
                }catch (Exception e){

                }

            }
        });

    }


    public void inflateListView(File[] file){
        List<Map<String,Object>> list = new ArrayList< Map<String,Object>>();
        Log.e("123",file.length+"");
        for(int i=0;i<file.length;i++)
        {
            Map<String,Object> map = new HashMap<String ,Object>();
            if(file[i].isDirectory()){
                map.put("icon",R.drawable.floder);
            }else{
                map.put("icon",R.drawable.file);
            }
            map.put("name",file[i].getName());
            list.add(map);
        }
        SimpleAdapter sa = new SimpleAdapter(this,list,R.layout.a0_54zuoye1,new String[]{"icon","name"},new int[]{R.id.activitysdcardfiles_list_layout_img1,R.id.activitysdcardfiles_list_layout_tv1});
        lv.setAdapter(sa);
        tv.setText(currentFather.getName());
    }

}

