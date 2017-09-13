package com.example.android.finishactivitybroadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ruxing on 2017/9/13.
 */

public class FinishActivityBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        //将注册的广播取消注册，如果不取消，会造成内存溢出。
        context.unregisterReceiver(this);
        if (action.equals("finishActivity")) {
            ((Activity) context).finish();
        }
    }
}
