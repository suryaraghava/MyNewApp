package com.restaurant.listener;

import com.restaurant.model.Item;

/**
 * Created by Munisekhar on 3/5/2017.
 */
public interface ItemListener {

    public void addItemToPlate(Item item);
    public void removeItemFromPlate(Item item);

}
