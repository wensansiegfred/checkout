package com.grocery.checkout;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.grocery.checkout.model.Customer;
import com.grocery.checkout.model.Product;
import com.grocery.checkout.model.Seller;
import com.grocery.checkout.model.Transaction;
import com.grocery.checkout.service.Checkout;

public class CheckoutBulkTest {

	/**
	 * manual test of bulk
	 */
	@Test
	public void testForBulkPrice() {
		Seller seller = new Seller("John Rambo");
    	Customer customer = new Customer("Jackie Chan");
    	Transaction transaction = new Transaction(seller, customer);
    	Checkout checkout = new Checkout(transaction);
    	checkout.add(new Product("Jeans", 0, "bulk", 3.1, 10));
    	assertTrue(3.1*10 == checkout.total());
	}
}
