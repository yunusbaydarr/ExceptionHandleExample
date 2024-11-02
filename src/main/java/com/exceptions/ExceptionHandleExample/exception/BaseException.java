package com.exceptions.ExceptionHandleExample.exception;

public class BaseException extends RuntimeException {

    public BaseException() {
    }
    public BaseException(ErrorMessage message) {
        super(message.prerapeErrorMessage());
    }


}
