package com.exceptions.ExceptionHandleExample.handler;


import lombok.Data;

@Data
public class ErrorBody<T> {

    private int status;
    private Exception<T> exception;
}
