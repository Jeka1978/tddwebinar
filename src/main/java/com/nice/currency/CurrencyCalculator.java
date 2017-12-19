package com.nice.currency;

/**
 * @author Evgeny Borisov
 */
public interface CurrencyCalculator {
    Money sum(Money money1, Money money2);
}
