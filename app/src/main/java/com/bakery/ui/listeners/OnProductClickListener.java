package com.bakery.ui.listeners;

import android.view.View;

public interface OnProductClickListener {

    void onAddCartClick(View v, int position, String quantity);

    void onCompareClick(View v, int position);

    void onOpenProductOverview(View v, int position);
}
