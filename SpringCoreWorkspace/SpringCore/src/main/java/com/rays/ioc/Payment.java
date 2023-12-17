package com.rays.ioc;

import org.springframework.beans.factory.annotation.Value;

public class Payment {
	
	@Value(value="100")
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double makePayment(double amt) {
		balance = balance-amt;
		return balance;
	}
	
	public double deposite (double amt) {
	balance = balance+amt;
	return balance;
	

}
}
