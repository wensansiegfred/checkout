package com.grocery.checkout.model;

import java.util.Random;

public class Seller {
	private String name;
	private Long id;

	protected Seller() {
		id = (long) randomId();
	}

	public Seller(String name) {
		this();
		this.name = name;
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


	private int randomId() {
		Random rand = new Random();
		return rand.nextInt(50000);
	}
}
