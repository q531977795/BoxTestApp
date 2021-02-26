package com.box.tv.test;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    //persist.scn.dhcpserver.enabled
    String TAG = "CH_BoxTest";
    String value = "";
    TextView tv_dhcp_value;
    Button bt_true, bt_false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    /**
     * 重启“川流TV”无障碍服务
     */
    protected void restartAccessService(){


    }


}