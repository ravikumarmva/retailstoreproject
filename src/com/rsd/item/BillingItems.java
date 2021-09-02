package com.rsd.item;

import com.rsd.util.Item;
import com.rsd.util.ItemType;


public class BillingItems implements Item {

    private final Item baseItem;

    public BillingItems(Item baseItem) {
        this.baseItem = baseItem;
    }

    public double getUnitPrice() { 
    	return baseItem.getUnitPrice();
    }

    public String getName() { 
    	return baseItem.getName(); 
    }
    
    public ItemType getType() {
    	return baseItem.getType(); 
    }

    public double priceForQuantity(int quantity) {
        return baseItem.priceForQuantity(quantity);
    }
}
