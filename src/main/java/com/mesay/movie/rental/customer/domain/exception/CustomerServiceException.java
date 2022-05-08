package com.mesay.movie.rental.customer.domain.exception;

public class CustomerServiceException extends RuntimeException{

    public static final int CUSTOMER_DOESNT_EXISTS = 10;

    private int code;

    public CustomerServiceException(String message, int code) {
        super(message);
        this.code = code;
    }
}