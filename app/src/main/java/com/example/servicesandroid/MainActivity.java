package com.example.servicesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startServiceBtn,stopServiceBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceBtn = findViewById(R.id.button);
        stopServiceBtn = findViewById(R.id.button2);


        startServiceBtn.setOnClickListener(view -> {
            startService(new Intent(this,sampleService.class));
        });
        stopServiceBtn.setOnClickListener(view -> {
            stopService(new Intent(this,sampleService.class));
        });

    }


}