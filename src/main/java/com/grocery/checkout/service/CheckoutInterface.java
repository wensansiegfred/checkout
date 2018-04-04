package com.grocery.checkout.service;

import com.grocery.checkout.model.Product;

public interface CheckoutInterface {
	void add(Product product);
	double total();
}
