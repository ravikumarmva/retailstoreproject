package com.rsd.unittest;

import org.junit.Before;
import org.junit.Test;
import com.rsd.util.Product;
import com.rsd.util.Customer;
import com.rsd.util.CustomerType;
import com.rsd.util.Cart;
import com.rsd.util.Item;
import com.rsd.util.ItemType;

import static org.junit.Assert.assertEquals;

public class WithoutDiscountsTest {

	private Cart cart;
	private Item item;

	@Before
	public void setUp() {
		Customer user = new Customer(CustomerType.OTHER, "Sekhar");
		cart = new Cart(user);
		item = new Product("Masks", 1000, ItemType.DIFFERENT_ITEMS);
	}

	@Test
	public void emptyCartCostsTest() {
		assertEquals(0, cart.total(), 0.01);
	}

	@Test
	public void singleBasicItemCostsTest() {
		cart.add(item);
		assertEquals(item.getUnitPrice(), cart.total(), 0.01);
	}


}
