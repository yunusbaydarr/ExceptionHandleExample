package com.exceptions.ExceptionHandleExample.handler;

import com.exceptions.ExceptionHandleExample.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
    public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorBody> handleBaseException(BaseException baseException , WebRequest webRequest){
        return ResponseEntity.badRequest().body(createErrorBody(baseException.getMessage() ,webRequest));
    }
    public <T> ErrorBody<T> createErrorBody (T message, WebRequest webRequest){

        ErrorBody<T> body = new ErrorBody<>();
        body.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<T> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setPath(webRequest.getDescription(false));
        exception.setMessage(message);

        body.setException(exception);

        return body;

    }

}
