package com.exceptions.ExceptionHandleExample.dto.response;

import com.exceptions.ExceptionHandleExample.entity.Category;
import lombok.Data;

@Data
public class DtoGetByIdProduct {
    private Long id;

    private String productName;

    private int inStock;

    private int price;

    private DtoGetByIdCategory category;
}
