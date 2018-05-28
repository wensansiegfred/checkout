package com.grocery.checkout.model;

import java.util.Random;

public class Product {
	private Long id;
	private String name;
	private double price;
	private String soldBy;//piece|bulk|discount
	private double quantity;
	private double aprice;//arbitrary price
	private double discount;

	protected Product() {
		id = (long) randomId();
	}

	public Product(String name, double price, String soldBy, double quantity, double aprice) {
		this();
		this.name = name;
		this.price = price;
		this.soldBy = soldBy;
		this.quantity = quantity;
		this.aprice = aprice;
	}

	public Product(String name, double price, String soldBy, double quantity, double aprice, double discount) {
		this();
		this.name = name;
		this.price = price;
		this.soldBy = soldBy;
		this.quantity = quantity;
		this.aprice = aprice;
		this.discount = discount;
	}

	public double getAprice() {
		return aprice;
	}

	public void setAprice(double aprice) {
		this.aprice = aprice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSoldBy() {
		return soldBy;
	}

	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	private int randomId() {
		Random rand = new Random();
		return rand.nextInt(50000);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", soldBy=" + soldBy + ", quantity=" + quantity + ", aprice="
				+ aprice + "]";
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
