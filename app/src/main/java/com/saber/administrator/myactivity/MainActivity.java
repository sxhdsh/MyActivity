package com.saber.administrator.myactivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.saber.administrator.data.BlackNumberDao;
import com.saber.administrator.data.QrCodeHelper;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {


    private QrCodeHelper qrCodeHelper;
    private BlackNumberDao blackNumberDao;
    private TimerTask timerTask;        //用于android计时器
    private Timer timer;

    Fragment3Activity fragment3Activity = new Fragment3Activity();
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(fragment1Activity).commit();
                    fragmentTransaction.replace(R.id.fr_ag1,fragment3Activity).commit();
                    break;
            }
        }
    };
    private Fragment1Activity fragment1Activity;
    private Fragment2Activity fragment2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qrCodeHelper = new QrCodeHelper(MainActivity.this);
        /*blackNumberDao = new BlackNumberDao(this);

        boolean i =  blackNumberDao.add("123","sda");*/
        long i = qrCodeHelper.add(this);
        Log.i("增加数据库返回的值是", Long.toString(i));
        fragment1Activity = new Fragment1Activity();
        fragment2Activity = new Fragment2Activity();

        FragmentManager fragment = getFragmentManager();
        FragmentTransaction transaction = fragment.beginTransaction();
        transaction.replace(R.id.fr_ag1, fragment1Activity);
        transaction.commit();

        FragmentManager fragmentManager1 = getFragmentManager();
        FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
        transaction1.replace(R.id.fr_ag2, fragment2Activity);
        transaction1.commit();

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };
        timer.schedule(timerTask,10*1000,10*1000);
    }
}
