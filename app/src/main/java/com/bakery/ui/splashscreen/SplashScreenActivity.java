package com.bakery.ui.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bakery.R;
import com.bakery.ui.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startLoginIntent();
            }
        }, SPLASH_TIME_OUT);
    }

    public void startLoginIntent() {
        Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
