package com.rsd.main;

import com.rsd.discount.DiscountItems;
import com.rsd.util.Cart;
import com.rsd.util.Customer;
import com.rsd.util.CustomerType;
import com.rsd.util.Item;
import com.rsd.util.ItemType;
import com.rsd.util.Product;

public class RetailStoreMain {
	
	public static void main(String[] args) {

		Customer employee = new Customer(CustomerType.EMPLOYEE, "Kiran");
        Item groceryItem = new Product("Dal", 100, ItemType.GROCERY);
        Item otherItem = new Product("Mask", 22, ItemType.DIFFERENT_ITEMS);
        DiscountItems discountItems = new DiscountItems();
        
        Cart cart = new Cart(employee, discountItems);
        cart.add(groceryItem, 2);
        cart.add(otherItem, 3);
      
        System.out.println(cart.total());        
    
	}

}
