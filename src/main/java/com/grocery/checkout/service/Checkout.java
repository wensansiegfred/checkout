package com.grocery.checkout.service;

import com.grocery.checkout.model.Product;
import com.grocery.checkout.model.Transaction;

public class Checkout implements CheckoutInterface {
	private Transaction transaction;

	public Checkout(Transaction transaction) {
		this.transaction = transaction;
	}

	public void add(Product product) {
		transaction.getProducts().add(product);
	}

	public double total() {
		double total = 0;
		for (Product product : transaction.getProducts()) {
			if (product.getSoldBy().equals("piece")) {
				total += product.getPrice() * product.getQuantity();
			} else if (product.getSoldBy().equals("bulk")) {
				total += product.getQuantity() * product.getAprice();
			}
		}
		return total;
	}

	public void print() {
		double total = 0;
		System.out.println("--------- Checking out --------");
		System.out.println("Transaction No." + transaction.getId());
		System.out.println("Customer Name: " + transaction.getCustomer().getName());
		System.out.println("Seller Name: " + transaction.getSeller().getName());
		System.out.println("");
		System.out.println("--------- ITEMS ------------");
		for (Product product : transaction.getProducts()) {
			System.out.println("Product No." + product.getId());
			System.out.println("Product Name: " + product.getName());
			System.out.println("Price: P" + product.getPrice());
			System.out.println("Quantity: " + product.getQuantity());
			if (product.getSoldBy().equals("piece")) {
				total += product.getPrice() * product.getQuantity();
			} else if (product.getSoldBy().equals("bulk")) {
				total += product.getQuantity() * product.getAprice();
			}
		}
		System.out.println("------------------------------");
		System.out.println("TOTAL: " + total);
	}
}
