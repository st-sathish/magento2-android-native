package com.bakery.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferencesHelperImpl implements AppPreferencesHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private final SharedPreferences mPrefs;

    public AppPreferencesHelperImpl(Context context) {
        mPrefs = context.getSharedPreferences("USER_DETAILS", Context.MODE_PRIVATE);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }
}
