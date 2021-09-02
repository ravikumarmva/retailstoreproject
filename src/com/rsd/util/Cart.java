package com.rsd.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

import com.rsd.discount.DiscountItems;
import com.rsd.item.BillingDiscount;

public class Cart {
	private Map<Item, Integer> quantities;
	private DiscountItems discountItems;
	private Customer customer;

	public Cart(Customer user) {
		quantities = new LinkedHashMap<Item, Integer>();
		this.customer = user;
	}

	public Cart(Customer user, DiscountItems discountPolicy) {
		quantities = new LinkedHashMap<Item, Integer>();
		this.customer = user;
		this.discountItems = discountPolicy;
	}

	public double total() {
		double result = 0;
		for (Item each : quantities.keySet()) {
			result += each.priceForQuantity(quantities.get(each));
		}

		if (discountItems != null) {
			result = discountItems.applyDiscount(result);
		}

		return result;
	}

	public void add(Item itemToBuy) {
		add(itemToBuy, 1);
	}

	//  add more quantities of item
	public void add(Item itemToBuy, int howMany) {
		Item item;

		// 30% discount in case of employee of store
		if (customer.getType() == CustomerType.EMPLOYEE) {
			item = new BillingDiscount(itemToBuy, 30);
		}
		// 10% discount in case of affiliate
		else if (customer.getType() == CustomerType.AFFILIATE) {
			item = new BillingDiscount(itemToBuy, 10);
		}

		// If a user has been a customer for 2 or more years apply 5% discount
		else if (customer.getType() == CustomerType.OTHER
				&& ChronoUnit.YEARS.between(customer.getJoiningDate(), LocalDateTime.now()) >= 2) {
			item = new BillingDiscount(itemToBuy, 5);
		}

		else {
			item = itemToBuy;
		}

		int previousQuantity = quantities.containsKey(item) ? quantities.get(item) : 0;
		quantities.put(item, previousQuantity + howMany);
	}
}
