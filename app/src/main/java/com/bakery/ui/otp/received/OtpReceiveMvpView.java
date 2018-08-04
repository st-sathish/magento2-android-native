package com.bakery.ui.otp.received;

import android.view.View;

import com.bakery.presenter.MvpView;

public interface OtpReceiveMvpView extends MvpView {

    void onContinueButtonClick(View v);

    void onExistingUserClick(View v);
}
