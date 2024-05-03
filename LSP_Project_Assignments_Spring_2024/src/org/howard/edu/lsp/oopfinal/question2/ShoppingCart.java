package org.howard.edu.lsp.oopfinal.question2;

//shopping cart
public class ShoppingCart {

	 private PaymentStrategy paymentStrategy;

	 public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		 this.paymentStrategy = paymentStrategy;
		 }

	 public void checkout(double amount) {
		 paymentStrategy.pay(amount);
		 }
	}
