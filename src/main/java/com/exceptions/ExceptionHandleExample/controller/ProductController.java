package com.exceptions.ExceptionHandleExample.controller;

import com.exceptions.ExceptionHandleExample.dto.request.DtoCreateProduct;
import com.exceptions.ExceptionHandleExample.dto.response.DtoGetByIdProduct;
import com.exceptions.ExceptionHandleExample.dto.response.DtoProduct;
import com.exceptions.ExceptionHandleExample.service.abstracts.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "getByIdProduct/{id}")
    public DtoGetByIdProduct getByIdProduct(@PathVariable(name = "id") Long id) {
        return productService.getByIdProduct(id);
    }

    @PostMapping(path = "create")
    public DtoProduct create(@RequestBody DtoCreateProduct dtoCreateProduct) {
        return this.productService.create(dtoCreateProduct);
    }
}
