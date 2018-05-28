package com.grocery.checkout.service;

import com.grocery.checkout.model.Product;
import com.grocery.checkout.model.SoldBy;
import com.grocery.checkout.model.Transaction;

public class Checkout implements CheckoutInterface {
	private Transaction transaction;

	public Checkout(Transaction transaction) {
		this.transaction = transaction;
	}

	public void add(Product product) {
		//Simple validation, usually we put this on the domain part using bean validation (Hibernate implementation)
		if (product.getQuantity() >= 1 && product.getPrice() >= 0)
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
			if (product.getSoldBy().equals(SoldBy.piece.name())) {
				total += getPrice(product.getPrice(), product.getQuantity());
				System.out.println("Price: P" + product.getPrice());
			} else if (product.getSoldBy().equals(SoldBy.bulk.name())) {
				total += getPrice(product.getAprice(), product.getQuantity());
				System.out.println("Total Price: P" + getPrice(product.getAprice(), product.getQuantity()));
			} else if (product.getSoldBy().equals(SoldBy.discount.name())) {
				total += getDiscountedPrice(product.getPrice(), product.getQuantity(), product.getDiscount());
				System.out.println("Total Price: P" + getDiscountedPrice(product.getPrice(), product.getQuantity(), product.getDiscount()));
			}

			System.out.println("Quantity: " + product.getQuantity());
			System.out.println("------------------------------");
		}

		System.out.println("TOTAL: " + total);
	}

	private double getPrice(double price, double quantity) {
		return price * quantity;
	}

	//assuming that the discount is per item
	private double getDiscountedPrice(double price, double quantity, double discount) {
		double discountedPrice = 0;
		if (quantity > 0) {
			for (int i=0; i < quantity; i++) {
				discountedPrice += price - (price * discount);
			}
		}
		return discountedPrice;
	}
}
