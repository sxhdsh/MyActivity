package com.lawliet.listviewwithlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lawliet.listviewwithlayout.activity.AddHeaderViewActivity;
import com.lawliet.listviewwithlayout.activity.CustomLinearlayoutActivity;
import com.lawliet.listviewwithlayout.activity.CustomListViewActivity;
import com.lawliet.listviewwithlayout.activity.NormalListViewActivity;
import com.lawliet.listviewwithlayout.activity.SetListViewHeightActivity;
import com.lawliet.listviewwithlayout.activity.UseAdapterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btn_normalListView, btn_customListView, btn_setListViewHeight, btn_customLinearlayout, btn_useAdapter, btn_addHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_normalListView = (Button) findViewById(R.id.btn_normalListView);
        btn_customListView = (Button) findViewById(R.id.btn_customListView);
        btn_setListViewHeight = (Button) findViewById(R.id.btn_setListViewHeight);
        btn_customLinearlayout = (Button) findViewById(R.id.btn_customLinearlayout);
        btn_useAdapter = (Button) findViewById(R.id.btn_useAdapter);
        btn_addHeaderView = (Button) findViewById(R.id.btn_addHeaderView);

        btn_normalListView.setOnClickListener(this);
        btn_customListView.setOnClickListener(this);
        btn_setListViewHeight.setOnClickListener(this);
        btn_customLinearlayout.setOnClickListener(this);
        btn_useAdapter.setOnClickListener(this);
        btn_addHeaderView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_normalListView:
                Intent intent1 = new Intent(MainActivity.this, NormalListViewActivity.class);
                startActivity(intent1);
                break;

            case R.id.btn_customListView:
                Intent intent2 = new Intent(MainActivity.this, CustomListViewActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_setListViewHeight:
                Intent intent3 = new Intent(MainActivity.this, SetListViewHeightActivity.class);
                startActivity(intent3);
                break;

            case R.id.btn_customLinearlayout:
                Intent intent4 = new Intent(MainActivity.this, CustomLinearlayoutActivity.class);
                startActivity(intent4);
                break;

            case R.id.btn_useAdapter:
                Intent intent5 = new Intent(MainActivity.this, UseAdapterActivity.class);
                startActivity(intent5);
                break;

            case R.id.btn_addHeaderView:
                Intent intent6 = new Intent(MainActivity.this, AddHeaderViewActivity.class);
                startActivity(intent6);
                break;
        }
    }
}
