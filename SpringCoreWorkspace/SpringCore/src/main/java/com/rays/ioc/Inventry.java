package com.rays.ioc;

import org.springframework.beans.factory.annotation.Value;

public class Inventry {

	@Value(value = "100")
	double stock;

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public double sold(double qty) {
		stock = stock - qty;
		return stock;

	}

}
