package com.rsd.unittest;

import org.junit.Before;
import org.junit.Test;
import com.rsd.util.Product;
import com.rsd.util.Customer;
import com.rsd.util.CustomerType;
import com.rsd.discount.DiscountItems;
import com.rsd.util.Cart;
import com.rsd.util.Item;
import com.rsd.util.ItemType;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

public class DiscountTest {

	private Item groceryItem;
	private Item otherItem;
	private Customer employee;
	private Customer customerWith2Years;
	private DiscountItems discountItems;

	@Before
	public void setUp() {
		employee = new Customer(CustomerType.EMPLOYEE, "Kiran");
		customerWith2Years = new Customer(CustomerType.OTHER, "Shankar", LocalDateTime.of(2018, 3, 01, 2, 20, 20));
		groceryItem = new Product("Rice", 20, ItemType.GROCERY);
		otherItem = new Product("TV", 222, ItemType.DIFFERENT_ITEMS);
		discountItems = new DiscountItems();
	}

	// No discount because of grocery item
	@Test   
	public void employeeGroceryTest() {
		Cart cart = new Cart(employee, discountItems);
		cart.add(groceryItem, 4);
		assertEquals(80, cart.total(), 0.01);

	}
	// 30% discount
	@Test
	public void employeeOtherItemTest() {
		Cart cart = new Cart(employee, discountItems);
		cart.add(otherItem, 4);
		assertEquals(591.6, cart.total(), 0.01);

	}


	// a customer for over 2 years,	he gets	a 5% discount
	@Test
	public void customerWith2YearsWithOtherItemTest() {
		Cart cart = new Cart(customerWith2Years, discountItems);
		cart.add(otherItem, 4);
		
		assertEquals(803.6, cart.total(), 0.01);

	}

}
