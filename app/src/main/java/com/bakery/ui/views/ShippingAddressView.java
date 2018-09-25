package com.bakery.ui.views;

import android.content.Context;
import android.widget.EditText;

import com.bakery.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ChildPosition;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

@Layout(R.layout.shipping_address)
public class ShippingAddressView {

    @ParentPosition
    private int mParentPosition;

    @ChildPosition
    private int mChildPosition;

    @View(R.id.first_name)
    private EditText firstNameEditTxt;

    @View(R.id.last_name)
    private EditText lastNameEditTxt;

    private Context mContext;

    public ShippingAddressView(Context context) {
        mContext = context;
    }

    @Resolve
    private void onResolved() {
        firstNameEditTxt.setText("hello");
        lastNameEditTxt.setText("test");
    }
}
