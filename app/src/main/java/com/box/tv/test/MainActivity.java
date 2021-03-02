package com.box.tv.test;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 作者:libeibei
 * 创建日期:20210226
 * 类说明:机顶盒测试app主界面
 **/
public class MainActivity extends BaseActivity implements View.OnClickListener {

    Intent startIntent;
    Button btTest_handler;
    Button btTest_access;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btTest_handler = (Button) findViewById(R.id.test_handler);
        btTest_access = (Button) findViewById(R.id.test_access);

        btTest_handler.setOnClickListener(this);
        btTest_access.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startIntent = new Intent();
        switch (view.getId()) {
            case R.id.test_handler:
                startIntent.setClassName("com.box.tv.test", "com.box.tv.test.activity.HandlerActivity");
                break;
            case R.id.test_access:
                startIntent.setClassName("com.box.tv.test", "com.box.tv.test.activity.AccessibilityActivity");
                break;
            default:
                break;
        }

        startActivity(startIntent);
    }
}