package org.howard.edu.lsp.oopfinal.question2;

//Concrete Class: Bitcoin Payment
class BitcoinPayment implements PaymentStrategy {
    private String bitcoinAddr;//Bitcoin address

    public BitcoinPayment(String bitcoinAddr) {
        this.bitcoinAddr = bitcoinAddr;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bitcoin address " + bitcoinAddr);
    }
}