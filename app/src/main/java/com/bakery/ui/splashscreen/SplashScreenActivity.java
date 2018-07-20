package com.bakery.ui.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bakery.R;
import com.bakery.ui.BaseAppCompatActivity;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.ui.login.LoginActivity;

public class SplashScreenActivity extends BaseAppCompatActivity implements SplashScreenMvpView {

    private SplashScreenPresenter mPresenter = new SplashScreenPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.fetchCategories();
        this.splash();
    }

    public void startLoginIntent() {
        Intent i = new Intent(SplashScreenActivity.this, LandingPageActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void splash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startLoginIntent();
            }
        }, 2000);
    }
}
