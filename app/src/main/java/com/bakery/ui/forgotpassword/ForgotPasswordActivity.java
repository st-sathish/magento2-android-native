package com.bakery.ui.forgotpassword;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bakery.ui.BaseAppCompatActivity;
import com.bakery.ui.login.LoginActivity;
import com.bakery.ui.login.LoginMvpPresenter;
import com.bakery.ui.login.LoginMvpView;
import com.bakery.ui.otp.received.OtpReceiveActivity;
import com.bakery.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by system2 on 30-Jan-18.
 */

public class ForgotPasswordActivity extends BaseAppCompatActivity implements ForgotPasswordMvpView {
    //Button button_continue;

    @BindView(R.id.edit_email)
    EditText mEmailEditText;

    ForgotPasswordPresenter forgotPasswordPresenter;

    TextView return_page;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passward);
        setUnBinder(ButterKnife.bind(this));
        forgotPasswordPresenter = new ForgotPasswordPresenter();
        forgotPasswordPresenter.onAttach(ForgotPasswordActivity.this);

        //button_continue=(Button)findViewById(R.id.button_continue);
        return_page=(TextView)findViewById(R.id.return_page);

        return_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

        /*button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgotPasswordActivity.this,OtpReceiveActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }

    @Override
    public void onExistingUserClick() {

    }

    @Override
    @OnClick(R.id.button_continue)
    public void onContinueButtonClick(View v) {
        forgotPasswordPresenter.onResetPasswordClick(mEmailEditText.getText().toString());
    }

    @Override
    protected void onDestroy() {
        forgotPasswordPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onForgotPasswordSuccessEmail() {
        showMessage("An email is sent to " + mEmailEditText.getText().toString() + ", with further instructions for password reset.");
        Intent intent=new Intent(ForgotPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
