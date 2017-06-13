package com.alextavella.fiap_android_alarm_service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alextavella.fiap_android_alarm_service.services.LogService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etTimer)
    EditText etTimer;

    public Intent intentLogService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btInit)
    public void dispatch(View v) {
        int _timer = Integer.parseInt(etTimer.getText().toString());
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (_timer * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + _timer + "seconds.", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btInitService)
    public void startLogService(View v) {
        intentLogService = new Intent(this, LogService.class);
        startService(intentLogService);
    }

    @OnClick(R.id.btStopService)
    public void stopLogService(View v) {
        if (intentLogService != null) {
            stopService(intentLogService);
        }
    }
}
