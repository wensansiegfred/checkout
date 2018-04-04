package com.grocery.checkout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.grocery.checkout.model.Customer;
import com.grocery.checkout.model.Product;
import com.grocery.checkout.model.Seller;
import com.grocery.checkout.model.Transaction;
import com.grocery.checkout.service.Checkout;

public class CheckoutPrintTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(System.out);
	}

	@Test
	public void testProductPrinted() {
		Seller seller = new Seller("John Rambo");
    	Customer customer = new Customer("Jackie Chan");
    	Transaction transaction = new Transaction(seller, customer);
    	Checkout checkout = new Checkout(transaction);
    	String productName = "Jeans";
    	checkout.add(new Product(productName, 9, "piece", 3, 0));
    	checkout.add(new Product("Tshirt", 9, "piece", 3, 0));
    	checkout.print();
    	Assert.assertThat(outContent.toString(), CoreMatchers.containsString(productName));
	}
}
