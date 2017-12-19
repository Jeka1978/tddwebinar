package com.nice.currency;

import com.nice.currency.exceptions.UnsupportedRateException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class CurrencyCalculatorImpl implements CurrencyCalculator {

    private Map<String, Double> currency2UsdRate = new HashMap<>();

    public void setCurrency2UsdRate(Map<String, Double> currency2UsdRate) {
        this.currency2UsdRate = currency2UsdRate;
    }

    public CurrencyCalculatorImpl() {
        currency2UsdRate.put("NIS", 3.5);
        currency2UsdRate.put("USD", 1.0);
    }


    public Money sum(Money money1, Money money2) {
        Money money1InUsd = convertToUsd(money1);
        Money money2InUsd = convertToUsd(money2);
        return new Money("USD", money1InUsd.getAmount() + money2InUsd.getAmount());
    }

    private Money convertToUsd(Money money) {
        if (!currency2UsdRate.containsKey(money.getCurrency())) {
            throw new UnsupportedRateException(money.getCurrency() + " is not supported yet");
        }
        Double rate = currency2UsdRate.get(money.getCurrency());
        return new Money("USD", money.getAmount() / rate);

    }


}
