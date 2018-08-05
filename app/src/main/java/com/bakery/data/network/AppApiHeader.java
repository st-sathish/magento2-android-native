package com.bakery.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppApiHeader {

    private ProtectedApiHeader mProtectedApiHeader;

    public AppApiHeader() {
        mProtectedApiHeader = new ProtectedApiHeader();
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return mProtectedApiHeader;
    }

    public static final class ProtectedApiHeader {

        @Expose
        @SerializedName("access_token")
        private String mAccessToken;

        public String getAccessToken() {
            return mAccessToken;
        }

        public void setAccessToken(String accessToken) {
            mAccessToken = accessToken;
        }
    }
}
