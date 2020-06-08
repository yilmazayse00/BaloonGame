package com.example.baloongame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    TextView tvScore;
    TextView tvTimer;
    int score;

    LottieAnimationView animationView1;
    LottieAnimationView animationView2;
    LottieAnimationView animationView3;
    LottieAnimationView animationView4;
    LottieAnimationView animationView5;
    LottieAnimationView animationView6;
    LottieAnimationView animationView7;
    LottieAnimationView animationView8;
    LottieAnimationView animationView9;
    LottieAnimationView[] lottieArray;

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvTimer = findViewById(R.id.tvTimer);
        tvScore = findViewById(R.id.tvScore);
        score = 0;

        animationView1 = findViewById(R.id.a1);
        animationView2 = findViewById(R.id.a2);
        animationView3 = findViewById(R.id.a3);
        animationView4 = findViewById(R.id.a4);
        animationView5 = findViewById(R.id.a5);
        animationView6 = findViewById(R.id.a6);
        animationView7 = findViewById(R.id.a7);
        animationView8 = findViewById(R.id.a8);
        animationView9 = findViewById(R.id.a9);
        lottieArray = new LottieAnimationView[]{animationView1,animationView2,animationView3,animationView4,animationView5,animationView6,animationView7,animationView8,animationView9};

        hideAnimation();

        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) { //her bir snyede ne yapılacağı
                tvTimer.setText("Time : " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() { //bittiğinde ne olacağı
                tvTimer.setText("Time off");
                handler.removeCallbacks(runnable);
                for(LottieAnimationView animation : lottieArray) {
                    animation.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(Main2Activity.this);
                alert.setTitle("Resart?");
                alert.setMessage("Are you sure to restart game?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //RESART
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }});

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }});
                alert.show();
            }
        }.start();
    }

    public void increaseScore(View view){
        score++;
        tvScore.setText("Score : " + score);
    }

    public void hideAnimation(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(LottieAnimationView animation : lottieArray){
                    animation.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9); // 0 - 8 arası
                lottieArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
    }
}
