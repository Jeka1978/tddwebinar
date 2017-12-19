package com.nice.currency;

import com.nice.currency.exceptions.UnsupportedRateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.HashMap;

/**
 * @author Evgeny Borisov
 */
//@RunWith(Parameterized.class)
public class CurrencyCalculatorTest {
    CurrencyCalculatorImpl calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new CurrencyCalculatorImpl();
        insertCurrencyRates(calculator);
    }

    @Test(expected = UnsupportedRateException.class)
    public void rateNotSupportedExceptionHappensWhenRateIsNotSupported() throws Exception {
        Money money1 = new Money("USD", 90);
        Money money2 = new Money("EUR", 90);
        calculator.sum(money1, money2);
    }

    @Test
    public void usdAndNISCanBeSummarised() throws Exception {

        Money money1 = new Money("USD", 90);
        Money money2 = new Money("NIS", 90);
        Money totalMoney = calculator.sum(money1, money2);
        Assert.assertEquals("USD", totalMoney.getCurrency());
        Assert.assertEquals(120, totalMoney.getAmount(), 0.000001);
    }

    private void insertCurrencyRates(CurrencyCalculatorImpl calculator) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("NIS", 3.0);
        map.put("USD", 1.0);
        calculator.setCurrency2UsdRate(map);
    }


    @BeforeClass
    public static void doPreparation(){
        System.out.println("This method will be invoked only once");
    }

}







