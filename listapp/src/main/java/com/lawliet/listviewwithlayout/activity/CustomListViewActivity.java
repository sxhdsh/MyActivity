package com.lawliet.listviewwithlayout.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ScrollView;

import com.lawliet.listviewwithlayout.R;
import com.lawliet.listviewwithlayout.adapter.NormalListViewAdapter;
import com.lawliet.listviewwithlayout.bean.ItemAdapterBean;
import com.lawliet.listviewwithlayout.view.ListViewForScroll;

import java.util.ArrayList;

/**
 * Created by lutao on 2016/1/8.
 */
public class CustomListViewActivity extends Activity
{
    Context context;
    ScrollView sv_customListView;
    ListViewForScroll lvfs_normallistview;
    NormalListViewAdapter normalListViewAdapter;
    ArrayList<ItemAdapterBean> itemAdapterBeanArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlistview);

        context = this;
        sv_customListView = (ScrollView) findViewById(R.id.sv_customListView);
        lvfs_normallistview = (ListViewForScroll) findViewById(R.id.lvfs_normallistview);

        for(int i=0;i<20;i++)
        {
            ItemAdapterBean itemAdapterBean = new ItemAdapterBean();
            itemAdapterBean.icon = R.drawable.item_icon;
            itemAdapterBean.text = Integer.toString(i);
            itemAdapterBeanArrayList.add(itemAdapterBean);
        }
        normalListViewAdapter = new NormalListViewAdapter(context, itemAdapterBeanArrayList);
        lvfs_normallistview.setAdapter(normalListViewAdapter);
        sv_customListView.smoothScrollTo(0,0);
    }

}
