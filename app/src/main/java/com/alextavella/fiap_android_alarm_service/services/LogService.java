package com.alextavella.fiap_android_alarm_service.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class LogService extends Service {

    private final String SERVICE_NAME = "SERVICE_MESSAGE";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i(SERVICE_NAME, "Initialize...");
    }

    @Override
    public void onDestroy() {
        Log.i(SERVICE_NAME, "Destroyed!");
    }
}
