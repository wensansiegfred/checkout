package com.grocery.checkout.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Transaction {
	private Long id;
	private Seller seller;
	private List<Product> products;
	private Customer customer;

	protected Transaction() {
		id = (long) randomId();
	}

	public Transaction(Seller seller, Customer customer) {
		this();
		this.seller = seller;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public List<Product> getProducts() {
		if (products == null)
			products = new ArrayList<Product>();
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private int randomId() {
		Random rand = new Random();
		return rand.nextInt(50000);
	}
}
