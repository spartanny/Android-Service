package com.example.servicesandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class sampleService extends Service {

    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.song);
        player.setLooping(false);
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        Log.d("start", "Service started");
        Thread serviceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                player.start();
            }
        });
        serviceThread.start();
        System.out.println("Duration of the song : " + player.getDuration());
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show();
        player.stop();
    }

}