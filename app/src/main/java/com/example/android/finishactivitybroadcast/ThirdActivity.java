package com.example.android.finishactivitybroadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by ruxing on 2017/9/13.
 */

public class ThirdActivity extends Activity implements View.OnClickListener {

    private Button btn_back;
    private Button btn_next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_back.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        registerBroadcastReceiver();
    }

    /**
     * 注册广播
     */
    private void registerBroadcastReceiver() {
        FinishActivityBroadcastReceiver mReceiver = new FinishActivityBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("finishActivity");
        registerReceiver(mReceiver, filter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_next:
                Intent intent = new Intent();
                intent.setClass(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
