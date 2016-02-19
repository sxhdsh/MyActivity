package com.lawliet.listviewwithlayout.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lawliet.listviewwithlayout.R;
import com.lawliet.listviewwithlayout.adapter.NormalListViewAdapter;
import com.lawliet.listviewwithlayout.bean.ItemAdapterBean;

import java.util.ArrayList;

/**
 * Created by lutao on 2016/1/8.
 */
public class NormalListViewActivity extends Activity
{
    Context context;
    ListView lv_normallistview;
    NormalListViewAdapter normalListViewAdapter;
    ArrayList<ItemAdapterBean> itemAdapterBeanArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normallistview);

        context = this;
        lv_normallistview = (ListView) findViewById(R.id.lv_normallistview);

        for(int i=0;i<20;i++)
        {
            ItemAdapterBean itemAdapterBean = new ItemAdapterBean();
            itemAdapterBean.icon = R.drawable.item_icon;
            itemAdapterBean.text = Integer.toString(i);
            itemAdapterBeanArrayList.add(itemAdapterBean);
        }
        normalListViewAdapter = new NormalListViewAdapter(context, itemAdapterBeanArrayList);
        lv_normallistview.setAdapter(normalListViewAdapter);
    }




}
