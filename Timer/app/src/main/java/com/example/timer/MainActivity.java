package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView timer;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 600000; // 10 minutes
    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.timer);

        findViewById(R.id.start).setOnClickListener(v -> {
            startTimer();
        });
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
    private void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText = "" + minutes + ":";
        if(seconds < 10){
            timeLeftText += "0";
        }
        timeLeftText += seconds;
        timer.setText(timeLeftText);
    }
}