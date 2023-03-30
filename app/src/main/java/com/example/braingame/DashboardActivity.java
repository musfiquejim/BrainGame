package com.example.braingame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class DashboardActivity extends AppCompatActivity {
CountDownTimer countDownTimer;
int timerValue = 20;
ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        progressBar = findViewById(R.id.quiz_timer);
        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue = timerValue -1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this,R.style.DiaLoge);
                dialog.setContentView(R.layout.time_out_dialog);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.show();

                dialog.findViewById(R.id.btn_ttyaAain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }.start();
    }
}