package org.howard.edu.lsp.oopfinal.question2;

//Concrete class: Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String CCNum;

    public CreditCardPayment(String CCNum) {
        this.CCNum = CCNum;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using credit card " + CCNum);
    }
}