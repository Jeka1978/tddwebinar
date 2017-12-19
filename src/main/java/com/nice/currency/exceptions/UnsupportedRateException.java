package com.nice.currency.exceptions;

/**
 * @author Evgeny Borisov
 */
public class UnsupportedRateException extends UnsupportedOperationException {
    public UnsupportedRateException(String message) {
        super(message);
    }
}
