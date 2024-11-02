package com.exceptions.ExceptionHandleExample.handler;

import lombok.Data;

import java.util.Date;

@Data
public class Exception <T>{
    private String path;

    private Date createTime;

    private T message;
}
