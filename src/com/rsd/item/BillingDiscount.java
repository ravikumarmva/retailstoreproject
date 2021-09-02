package com.rsd.item;

import com.rsd.util.Item;
import com.rsd.util.ItemType;


public class BillingDiscount extends BillingItems {

    private final double priceFactor;

    public BillingDiscount(Item baseItem, int percentPromotion) {
        super(baseItem);
        if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("percent must be in 0 to 100 only");
        }
        this.priceFactor = (100 - percentPromotion) / 100.0;
    }

    @Override
    public double priceForQuantity(int quantity) {
    
    	if (super.getType() == ItemType.GROCERY) {
    		return super.priceForQuantity(quantity);
    	}
    	
    
        return (super.priceForQuantity(quantity) * priceFactor);
    }
}
