package org.howard.edu.lsp.oopfinal.question2;

//Concrete class: PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String emailAddr;

    public PayPalPayment(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal account " + emailAddr);
    }
}

