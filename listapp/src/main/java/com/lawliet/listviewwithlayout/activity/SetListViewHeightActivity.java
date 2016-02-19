package com.lawliet.listviewwithlayout.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
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
public class SetListViewHeightActivity extends Activity
{
    /**只要在设置ListView的Adapter后调用此静态方法即可让ListView正确的显示在其父ListView的ListItem中。但是要注意的是，
     * 子ListView的每个Item必须是LinearLayout，不能是其他的，因为其他的Layout(如RelativeLayout)没有重写onMeasure()，所以会在onMeasure()时抛出异常。
     * 前提条件是布局文件中ListView的高度要指定，这样才能重新计算，不要设成wapcontent！
     * 原理：ListView根据adapter计算ListView应有的高度，并设置。当ListView具备了应有的高度后，在滑动事件上依然是如果ListView够大导致ScrollView超
     * 出了屏幕范围，则ScrollView滑动；否则不滑动。
     * 局限：在每个ListView会变化的地方都要调用该方法。
     */
    Context context;
    ScrollView sv_normallistview;
    ListView lv_normallistview;
    NormalListViewAdapter normalListViewAdapter;
    ArrayList<ItemAdapterBean> itemAdapterBeanArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normallistview);

        context = this;
        sv_normallistview = (ScrollView) findViewById(R.id.sv_normallistview);
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
        sv_normallistview.smoothScrollTo(0, 0);
        setListViewHeightBasedOnChildren(lv_normallistview);

    }


    public static void setListViewHeightBasedOnChildren(ListView listView)
    {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
        {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++)
        {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
