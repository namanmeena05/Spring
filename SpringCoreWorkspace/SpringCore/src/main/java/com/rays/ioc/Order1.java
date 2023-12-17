package com.rays.ioc;

public class Order1 {
	
	private Payment payment;
	private Inventry inventry;
	
	public Order1(Payment payment, Inventry inventry) {
		
		this.payment = payment;
		this.inventry = inventry;
	}
	
	public void bookATicket(int items) {
		
		int price = 10;
		
		double totalAmount = items * price;
		
		double updatedBalance  = payment.makePayment(totalAmount);
		
		int updatedStock = (int) inventry.sold(items);
		
		System.out.println("tickets booked");
		System.out.println("total amount paid :"+totalAmount);
		System.out.println("balance left:"+updatedBalance);
		System.out.println("stock left :" + updatedStock);
	}
	
	
	

}
