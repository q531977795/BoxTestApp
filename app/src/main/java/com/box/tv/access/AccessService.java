package com.box.tv.access;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

/**
 * 作者:libeibei
 * 创建日期:20210127
 * 类说明:无障碍服务测试类
 **/
public class AccessService extends AccessibilityService {

    static final String TAG = "CH_Access";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Log.i(TAG, "-----> onAccessibilityEvent() = " + accessibilityEvent.toString());
    }

    @Override
    public void onInterrupt() {
        Log.i(TAG, "-----> onInterrupt()");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.i(TAG, "-----> onServiceConnected()");
    }

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        Log.i(TAG, "-----> onKeyEvent() = " + event.toString());
        return super.onKeyEvent(event);
    }
}
