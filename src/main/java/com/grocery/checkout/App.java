package com.grocery.checkout;

import com.grocery.checkout.model.Customer;
import com.grocery.checkout.model.Product;
import com.grocery.checkout.model.Seller;
import com.grocery.checkout.model.Transaction;
import com.grocery.checkout.service.Checkout;

public class App {
    public static void main( String[] args ) {
    	Seller seller = new Seller("John Rambo");
    	Customer customer = new Customer("Jackie Chan");
    	Transaction transaction = new Transaction(seller, customer);
    	Checkout checkout = new Checkout(transaction);
    	checkout.add(new Product("Jeans", 9, "piece", 3, 0,0));
    	checkout.add(new Product("Brep", 9, "piece", 3, 0,0));

    	checkout.print();
    }
}
