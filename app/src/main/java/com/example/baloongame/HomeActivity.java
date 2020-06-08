package com.example.baloongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClickI(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickII(View view) {
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
        finish();
    }

    public void onClickIII(View view) {
        Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(intent);
        finish();
    }
}
