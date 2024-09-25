package com.sonu.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductDataException extends RuntimeException {

    public ProductDataException(String message) {
        super(message);
    }

    public ProductDataException(Exception ex) {
        super(ex);
    }

}
