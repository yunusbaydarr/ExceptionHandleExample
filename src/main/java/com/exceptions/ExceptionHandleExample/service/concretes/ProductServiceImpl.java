package com.exceptions.ExceptionHandleExample.service.concretes;

import com.exceptions.ExceptionHandleExample.dto.request.DtoCreateProduct;
import com.exceptions.ExceptionHandleExample.dto.response.DtoGetByIdCategory;
import com.exceptions.ExceptionHandleExample.dto.response.DtoGetByIdProduct;
import com.exceptions.ExceptionHandleExample.dto.response.DtoProduct;
import com.exceptions.ExceptionHandleExample.entity.Category;
import com.exceptions.ExceptionHandleExample.entity.Product;
import com.exceptions.ExceptionHandleExample.exception.BaseException;
import com.exceptions.ExceptionHandleExample.exception.ErrorMessage;
import com.exceptions.ExceptionHandleExample.exception.MessageType;
import com.exceptions.ExceptionHandleExample.repository.ProductRepository;
import com.exceptions.ExceptionHandleExample.service.abstracts.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DtoGetByIdProduct getByIdProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS,id.toString()));
        }
        Product product = optionalProduct.get();
        DtoGetByIdProduct dtoProduct = new DtoGetByIdProduct();

        dtoProduct.setId(product.getId());
        dtoProduct.setProductName(product.getProductName());
        dtoProduct.setInStock(product.getInStock());
        dtoProduct.setPrice(product.getPrice());

        Category category = optionalProduct.get().getCategory();
        DtoGetByIdCategory dtoCategory = new DtoGetByIdCategory();
        dtoCategory.setId(category.getId());
        dtoCategory.setCategoryName(category.getCategoryName());

        dtoProduct.setCategory(dtoCategory);
        return dtoProduct;

/*
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS,id.toString()));
        }
        Product product = optionalProduct.get();
        DtoGetByIdProduct dtoProduct = new DtoGetByIdProduct();
        BeanUtils.copyProperties(product,dtoProduct);

        Category category = optionalProduct.get().getCategory();
        DtoGetByIdCategory dtoCategory = new DtoGetByIdCategory();
        BeanUtils.copyProperties(category,dtoCategory);

        dtoProduct.setCategory(dtoCategory);
        return dtoProduct;*/
    }

    @Override
    public DtoProduct create(DtoCreateProduct dtoCreateProduct) {

        Product product = new Product();
        product.setProductName(dtoCreateProduct.getProductName());
        product.setInStock(dtoCreateProduct.getInStock());
        product.setPrice(dtoCreateProduct.getPrice());

        Category category = new Category();
        category.setId(dtoCreateProduct.getCategory().getId());

        product.setCategory(category);

        DtoProduct response = new DtoProduct();
        response.setProductName(product.getProductName());
        response.setPrice(product.getPrice());
        response.setInStock(product.getInStock());
        return response;


    }
}
