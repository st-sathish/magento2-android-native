package com.bakery.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.bakery.R;
import com.bakery.ui.BaseAppCompatActivity;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.ui.landingpage.NavicationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by system2 on 30-Jan-18.
 */

public class SignUpActivity extends BaseAppCompatActivity implements SignUpMvpView {

    @BindView(R.id.first_name)
    EditText firstName;

    @BindView(R.id.last_name)
    EditText lastName;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.phone_number)
    EditText phone;

    SignUpMvpPresenter<SignUpMvpView> mPresenter = new SignUpPresenter<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_signup);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(SignUpActivity.this);
    }

    @OnClick(R.id.button_register)
    public void onRegisterBtnClick(View view) {
        mPresenter.onRegisterBtnClick(email.getText().toString(), firstName.getText().toString(),
                lastName.getText().toString(), password.getText().toString(), phone.getText().toString());
    }

    @Override
    public void openLandingPageActivity() {
        Intent intent = new Intent(SignUpActivity.this, LandingPageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
