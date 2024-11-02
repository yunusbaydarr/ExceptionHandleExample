package com.exceptions.ExceptionHandleExample.dto.request;

import com.exceptions.ExceptionHandleExample.dto.response.DtoGetByIdCategory;
import com.exceptions.ExceptionHandleExample.entity.Category;
import lombok.Data;

@Data
public class DtoCreateProduct {

    private String productName;

    private int inStock;

    private int price;

    private DtoGetByIdCategory category;
}
