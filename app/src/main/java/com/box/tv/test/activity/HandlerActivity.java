package com.box.tv.test.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.box.tv.test.BaseActivity;
import com.box.tv.test.R;

import java.lang.ref.WeakReference;

/**
 * 作者:libeibei
 * 创建日期:20210226
 * 类说明:handler 测试界面
 **/
public class HandlerActivity extends BaseActivity implements View.OnClickListener {
    TextView tv_handler;
    Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        initView();
        //test();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


        }
    };

    private void initView() {
        tv_handler = (TextView) findViewById(R.id.handler_text);
        bt = (Button) findViewById(R.id.handler_button);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        test2();
    }

    public void test1() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                Log.e(TAG, "------1");
                Looper.prepare();
                Handler h = new Handler() {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        Log.e(TAG, "----- what =" + msg.what);

                    }
                };
                Log.e(TAG, "------2");
                Looper.loop();
                Log.e(TAG, "Handler 创建完成");
            }
        }.start();
    }


    public void test2() {
        Log.e(TAG, "Handler = " + handler.getClass());
    }

}
