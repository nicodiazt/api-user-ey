package com.tte.exception;

public class CustomException extends RuntimeException {
    public CustomException(String mensaje) {
        super(mensaje);
    }
}
