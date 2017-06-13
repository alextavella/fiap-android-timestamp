package com.alextavella.fiap_android_alarm_service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alextavella.fiap_android_alarm_service.services.BoundService;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by alextavella on 12/06/17.
 */

public class BoundActivity extends AppCompatActivity {

    @BindView(R.id.tvTimestamp)
    TextView tvTimestamp;

    private BoundService mBoundService;
    private boolean mServiceBound = false;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder)
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_activity);
    }

    @OnClick(R.id.btPrint)
    public void print(View v) {
        if (mServiceBound) {
            tvTimestamp.setText(mBoundService.getTimer());
        }
    }

    @OnClick(R.id.btStop)
    public void stop(View v) {
        if (mServiceBound) {
            unbindService(mService);
        }
    }
}
