package com.bakery.ui.forgotpassword;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bakery.ui.otp.received.OtpReceiveActivity;
import com.bakery.R;

/**
 * Created by system2 on 30-Jan-18.
 */

public class ForgetPasswordActivity extends AppCompatActivity {
    Button button_continue;
    TextView return_page;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passward);

        button_continue=(Button)findViewById(R.id.button_continue);
        return_page=(TextView)findViewById(R.id.return_page);

        return_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgetPasswordActivity.this,OtpReceiveActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
