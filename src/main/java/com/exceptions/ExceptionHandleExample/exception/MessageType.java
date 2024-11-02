package com.exceptions.ExceptionHandleExample.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXISTS("1001","Kayıt Bulunumadı "),
    COULD_NOT_REGISTER("2222", "Kayıt yapılamadı");

    private String code;
    private String message;
    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
