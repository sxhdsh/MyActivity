package com.saber.administrator.myactivity;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.ApplicationTestCase;

import com.saber.administrator.data.QrCodeHelper;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public Context mContext;

    public ApplicationTest() {
        super(Application.class);
    }

    public void TestAdd(){
        QrCodeHelper qrCodeHelper = new QrCodeHelper(mContext);


    }
}