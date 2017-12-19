package com.nice.currency;

/**
 * @author Evgeny Borisov
 */
public class Money {
    private final String currency;
    private final double amount;

    public Money(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }
}
