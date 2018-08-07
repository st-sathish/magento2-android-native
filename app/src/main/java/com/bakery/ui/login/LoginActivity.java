package com.bakery.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.bakery.data.pref.AppPreferencesHelperImpl;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.ui.forgotpassword.ForgotPasswordActivity;
import com.bakery.ui.signup.SignUpActivity;
import com.bakery.R;
import com.bakery.ui.BaseAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by system2 on 22-Dec-17.
 */

public class LoginActivity extends BaseAppCompatActivity implements LoginMvpView {

    @BindView(R.id.edit_email)
    EditText mEmailEditText;

    @BindView(R.id.edit_password)
    EditText mPasswordEditText;

    LoginMvpPresenter<LoginMvpView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUnBinder(ButterKnife.bind(this));
        mPresenter = new LoginPresenter<>();
        mPresenter.onAttach(LoginActivity.this);
        mEmailEditText.setText("sukumar.inapp2@gmail.com");
        mPasswordEditText.setText("rails123$");
    }

    @Override
    public void openLandingPageActivity() {
        Intent intent = new Intent(LoginActivity.this, LandingPageActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.button_login)
    public void onLoginBtnClick(View v) {
        mPresenter.onLoginBtnClick(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }

    @OnClick(R.id.forgot_password)
    @Override
    public void onForgotPasswordClick(View v) {
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.new_account)
    @Override
    public void onNewAccountClick(View v) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
