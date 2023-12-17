package com.rays.ioc;

public class Order {
	
	private Payment payment;
	private Inventry inventry;
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Inventry getInventry() {
		return inventry;
	}
	public void setInventry(Inventry inventry) {
		this.inventry = inventry;
	}
	
	public void bookATicket(int item) {
		int price = 10;

		double totalAmount = item * price;

		double updatedBalance = payment.makePayment(totalAmount);

		int updatedStock = (int) inventry.sold(item);

		System.out.println("Tickets are Booked");
		System.out.println("Total Amount Paid: " + totalAmount);
		System.out.println("Remaining Balance: " + updatedBalance);
		System.out.println("Updated Stock: " + updatedStock);
	}
	
	

}
