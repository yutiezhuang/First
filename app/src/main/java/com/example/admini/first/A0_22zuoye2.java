package com.example.admini.first;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/31.
 */
public class A0_22zuoye2 extends Activity {
    ExpandableListView edlv;
    String []one={"东北","西北","西南","东南","中心"};
    String[][]two={{"长白山","大兴安岭","鸭绿江"},{"火焰山","秦岭","青海湖"},{"大理寺","西双版纳","丽江"},{"西湖","东方明珠","古都南京"},{"少林寺","洛阳城","嵩山"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_22zuoye2);
        edlv= (ExpandableListView) findViewById(R.id.city1);
        ExpandableListAdapter ela=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return one.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return two[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return one[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return two[groupPosition][childPosition];
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
                TextView tv=new TextView(A0_22zuoye2.this);
                tv.setText(one[groupPosition]);
                return tv;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView tv=new TextView(A0_22zuoye2.this);
                tv.setText(two[groupPosition][childPosition]);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
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
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        edlv.setAdapter(ela);
        edlv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent i=getIntent();
                i.putExtra("city",two[groupPosition][childPosition]);
                setResult(123,i);
                finish();
                return true;
            }
        });
    }
}
