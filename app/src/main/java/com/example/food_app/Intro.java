package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Intro extends AppCompatActivity {
    //Introduction Activity(Application starts here)

    //Variable Definitions
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        timer = new Timer();         //Create timer obj
        //To automatically switch activity after timer over
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Intro.this, Dashboard.class);   //Switch to Dashboard
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}