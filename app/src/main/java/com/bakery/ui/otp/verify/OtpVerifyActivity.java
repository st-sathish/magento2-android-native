package com.bakery.ui.otp.verify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.ui.BaseAppCompatActivity;
import com.bakery.ui.forgotpassword.ForgotPasswordActivity;
import com.bakery.ui.otp.received.OtpReceiveActivity;

/**
 * Created by system2 on 30-Jan-18.
 */

public class OtpVerifyActivity extends BaseAppCompatActivity {
    int size=1;
    TextView resend;
    Button auto;
    EditText editText1,editText2,editText3,editText4,editText5,editText6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);

        init();

        editText1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(editText1.getText().toString().length()==size)     //size as per your requirement
                {

                    editText2.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }});
        editText2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(editText2.getText().toString().length()==size)     //size as per your requirement
                {

                    editText3.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }});
        editText3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(editText3.getText().toString().length()==size)     //size as per your requirement
                {

                    editText4.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }});
        editText4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(editText4.getText().toString().length()==size)     //size as per your requirement
                {
                    editText5.requestFocus();

                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }});
        editText5.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(editText5.getText().toString().length()==size)     //size as per your requirement
                {

                    editText6.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }});
        editText6.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(editText6.getText().toString().length()==size)     //size as per your requirement
                {

                    InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(editText6.getWindowToken(), 0);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }});

        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtpVerifyActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });


        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtpVerifyActivity.this,OtpReceiveActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    void init(){
        resend=(TextView)findViewById(R.id.resend);
        auto=(Button)findViewById(R.id.button_autocode);
        editText1=(EditText)findViewById(R.id.edit_pin1);
        editText2=(EditText)findViewById(R.id.edit_pin2);
        editText3=(EditText)findViewById(R.id.edit_pin3);
        editText4=(EditText)findViewById(R.id.edit_pin4);
        editText5=(EditText)findViewById(R.id.edit_pin5);
        editText6=(EditText)findViewById(R.id.edit_pin6);
    }
}
