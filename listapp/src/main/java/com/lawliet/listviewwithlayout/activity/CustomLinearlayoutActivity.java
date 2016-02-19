package com.lawliet.listviewwithlayout.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.lawliet.listviewwithlayout.R;
import com.lawliet.listviewwithlayout.adapter.NormalListViewAdapter;
import com.lawliet.listviewwithlayout.bean.ItemAdapterBean;
import com.lawliet.listviewwithlayout.view.LinearLayoutListView;

import java.util.ArrayList;

/**
 * Created by lutao on 2016/1/8.
 */
public class CustomLinearlayoutActivity extends Activity
{
    Context context;
    LinearLayoutListView lllv_customlinearlayout;
    NormalListViewAdapter normalListViewAdapter;
    ArrayList<ItemAdapterBean> itemAdapterBeanArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlinearlayout);

        context = this;
        lllv_customlinearlayout = (LinearLayoutListView) findViewById(R.id.lllv_customlinearlayout);

        for(int i=0;i<20;i++)
        {
            ItemAdapterBean itemAdapterBean = new ItemAdapterBean();
            itemAdapterBean.icon = R.drawable.item_icon;
            itemAdapterBean.text = Integer.toString(i);
            itemAdapterBeanArrayList.add(itemAdapterBean);
        }
        normalListViewAdapter = new NormalListViewAdapter(context, itemAdapterBeanArrayList);
        lllv_customlinearlayout.setAdapter(normalListViewAdapter);
    }
}
