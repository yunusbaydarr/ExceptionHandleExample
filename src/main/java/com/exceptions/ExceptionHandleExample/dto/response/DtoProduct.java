package com.exceptions.ExceptionHandleExample.dto.response;

import lombok.Data;

@Data
public class DtoProduct {
    private String productName;

    private int inStock;

    private int price;
}
