package com.exceptions.ExceptionHandleExample.service.abstracts;

import com.exceptions.ExceptionHandleExample.dto.request.DtoCreateProduct;
import com.exceptions.ExceptionHandleExample.dto.response.DtoGetByIdProduct;
import com.exceptions.ExceptionHandleExample.dto.response.DtoProduct;

public interface ProductService {

    public DtoGetByIdProduct getByIdProduct(Long id);

    public DtoProduct create (DtoCreateProduct dtoCreateProduct);
}
