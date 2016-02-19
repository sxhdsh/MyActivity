package com.saber.administrator.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/2/17 9:37。
 * 创建人 ：朱家琪
 * 版本 ：1.0
 * * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 */
public class QrCodeHelper {

    //数据库表名
    public static final String QRCODE = "qrcode";


    //自增id
    public static String _ID = "ID";

    public static final String ERROR_CODE="errorCode";//0为正确，其他为错误码，如果请求成功错误码忽略
    public static final String STORECODE="storecode";//返回店面Code，如果没有为空
    public static final String STORENAME="storename";//店面名称
    public static final String PRODUCTFAMILY="productfamily";//机器类型
    public static final String ERROR_MSG="errorMsg";//错误码对应的错误信息



    //建表语句
    public static final String CREATE_TABLE =

            /*"CREATE TABLE "+ QRCODE+"("+_ID +" INTEGER PRIMARY ," +
                    ERROR_CODE+" INTEGER , "
                    +STORECODE+" TEXT , "
                    +STORENAME+" TEXT , "
                    +PRODUCTFAMILY+" TEXT , "
                    +ERROR_MSG+" TEXT ,"
                    +");";*/

            "create table " + QRCODE+"("+_ID+"integer primary ," +
            ERROR_CODE+" INTEGER , "
            +STORECODE+" TEXT , "
            +STORENAME+" TEXT , "
            +PRODUCTFAMILY+" TEXT , "
            +ERROR_MSG+" TEXT)";

           /* "CREATE TABLE IF NOT EXISTS "+ QRCODE
                    +"("+_ID +" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    +ERROR_CODE+" INTEGER , "
                    +STORECODE+" TEXT , "
                    +STORENAME+" TEXT , "
                    +PRODUCTFAMILY+" TEXT , "
                    +ERROR_MSG+" TEXT"
                    +");";*/
    private DBHelper dbHelper;

    public QrCodeHelper(Context context){
        if(dbHelper == null){
            dbHelper = new DBHelper(context);
        }
    }
    //添加数据
    public long add(Context context){
        if(dbHelper == null){
            dbHelper = new DBHelper(context);
        }
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        if(sqLiteDatabase == null){
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(ERROR_CODE,11);
        /*contentValues.put(STORECODE, "asd");
        contentValues.put(STORENAME, "fas");
        contentValues.put(PRODUCTFAMILY,"");
        contentValues.put(ERROR_MSG,"asd");*/
        long i = sqLiteDatabase.insert(QRCODE,null,contentValues);

        sqLiteDatabase.close();
        dbHelper.close();
        return i;
    }

}
