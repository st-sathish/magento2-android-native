package com.bakery.data.network.order;

import com.bakery.data.network.models.OrderRequest;

import io.reactivex.Observable;

public interface OrderApi {

    Observable<String> placeOrder(OrderRequest order);

}
