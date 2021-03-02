package com.box.tv.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.box.tv.test.BaseActivity;
import com.box.tv.test.R;

/**
 * 作者:libeiei
 * 创建日期:20210226
 * 类说明:
 * 测试无障碍服务的页面
 **/
public class AccessibilityActivity extends BaseActivity implements View.OnClickListener {
    String value = "";
    TextView tv_dhcp_value;
    Button bt_true, bt_false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        refreshValue();
    }

    void initView() {
        tv_dhcp_value = (TextView) findViewById(R.id.tv_value_dhcpserver);
        bt_true = (Button) findViewById(R.id.button_change_true);
        bt_false = (Button) findViewById(R.id.button_change_false);
        bt_true.setOnClickListener(this);
        bt_false.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_change_true) {
            Log.i(TAG, "-----> clicked true");
            Settings.Secure.putInt(getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED, 1);
        }
        if (view.getId() == R.id.button_change_false) {
            Log.i(TAG, "-----> clicked false");
            Settings.Secure.putInt(getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED, 0);
        }
        refreshValue();
    }

    private void refreshValue() {
        String settingValue = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
        tv_dhcp_value.setText("" + settingValue.toString());
    }
}
