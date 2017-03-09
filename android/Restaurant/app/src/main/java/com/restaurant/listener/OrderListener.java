package com.restaurant.listener;

/**
 * Created by Munisekhar on 3/9/2017.
 */
public interface OrderListener {

    public void onCartChange();
    public void onOrderClick();
    public void onMoreClick();
    public void onFinishOrder();
}
