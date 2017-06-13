package com.alextavella.fiap_android_alarm_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by alextavella on 12/06/17.
 */

public class AlarmReceiver extends BroadcastReceiver {

    private MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.fuckoff);
        mp.start();
        Toast.makeText(context, "Alarm started!", Toast.LENGTH_SHORT).show();
    }
}
