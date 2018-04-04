package com.grocery.checkout;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.grocery.checkout.model.Customer;
import com.grocery.checkout.model.Product;
import com.grocery.checkout.model.Seller;
import com.grocery.checkout.model.Transaction;
import com.grocery.checkout.service.Checkout;

public class CheckoutPieceTest {

	@Test
	public void testProductTotal() {
		Seller seller = new Seller("John Rambo");
    	Customer customer = new Customer("Jackie Chan");
    	Transaction transaction = new Transaction(seller, customer);
    	Checkout checkout = new Checkout(transaction);
    	String productName = "Wrangler";
    	checkout.add(new Product(productName, 9.0, "piece", 3, 0));
    	assertTrue(9.0*3 == checkout.total());
	}

	@Test
	public void testZeroTotal() {
		Seller seller = new Seller("John Rambo");
    	Customer customer = new Customer("Jackie Chan");
    	Transaction transaction = new Transaction(seller, customer);
    	Checkout checkout = new Checkout(transaction);
    	assertTrue(0 == checkout.total());
	}

	/**
	 * this is a manual implementation of discount
	 */
	@Test
	public void testTotalWithItemsZeroPrice() {
		Seller seller = new Seller("John Rambo");
    	Customer customer = new Customer("Jackie Chan");
    	Transaction transaction = new Transaction(seller, customer);
    	Checkout checkout = new Checkout(transaction);

    	checkout.add(new Product("Jeans", 9.0, "piece", 1, 0));
    	checkout.add(new Product("Jeans", 0, "piece", 1, 0));
    	checkout.add(new Product("Jeans", 8, "piece", 1, 0));
    	assertTrue(9.0 + 8 == checkout.total());
	}
}
