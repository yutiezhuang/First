package com.example.admini.first;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/27.
 */
public class zuoye14Activity extends BaseActivity {
    TextView tv;
    private String[] wName={"最简单的爱是","：我想你了","最难的的解释是","：我想静静","我非薄荷","为何心凉","我非柠檬","为何心酸"};
    private String[][] nNanme={{">香蕉"," >菠萝","  >苹果","   >甘蔗","    >荔枝","     >核桃"},{"Ο既"," Ο然","  Ο爱","   Ο请","   Ο相","     Ο爱"},{"Ο若"," Ο不","  Ο爱","   Ο请","    Ο放","     Ο开"},
            {"～天","  ～长","    ～地","     ～久"},
            {"～曾","  ～经","    ～拥","      ～有"},{"┏没","  ┓心","  ┗没","   ┛肺"},{"撕","心","裂","肺"},{"   ァ世界这么大想去看看","   ァ你妈叫你回家吃饭","   ァ这么任性你家里人知道么"}};
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.zuoye14);
        ExpandableListAdapter ela=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return wName.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return nNanme[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return wName[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return nNanme[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LayoutInflater li=LayoutInflater.from(zuoye14Activity.this);
                View v=li.inflate(android.R.layout.simple_list_item_1,null);
                TextView tv= (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(90,0,0,0);
                tv.setTextColor(Color.RED);
                tv.setText(wName[groupPosition]);
                return v;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView tv = new TextView(zuoye14Activity.this);
                tv.setPadding(90,0,0,0);
                tv.setTextColor(Color.CYAN);
                tv.setText(nNanme[groupPosition][childPosition]);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return childId;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return groupId;
            }
        };
        ExpandableListView view = (ExpandableListView) findViewById(R.id.expandlist);
        tv= (TextView) findViewById(R.id.text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(zuoye14Activity.this,qq.class);
                startActivity(i);
            }
        });
        view.setAdapter(ela);

    }
}
