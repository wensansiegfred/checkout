package com.grocery.checkout;

import com.grocery.checkout.model.Customer;
import com.grocery.checkout.model.Product;
import com.grocery.checkout.model.Seller;
import com.grocery.checkout.model.SoldBy;
import com.grocery.checkout.model.Transaction;
import com.grocery.checkout.service.Checkout;

public class App {
    public static void main( String[] args ) {
    	Seller seller = new Seller("John Rambo");
    	Customer customer = new Customer("Jackie Chan");
    	Transaction transaction = new Transaction(seller, customer);
    	Checkout checkout = new Checkout(transaction);
    	checkout.add(new Product("Jeans", 1, SoldBy.piece.name(), 1));
    	checkout.add(new Product("Tee Shirt", 1, SoldBy.discount.name(), 3, 0.10));
    	checkout.add(new Product("Jacket", 1, SoldBy.bulk.name(), 3, 0, 0));

    	checkout.print();
    }
}
