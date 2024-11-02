package com.exceptions.ExceptionHandleExample.repository;
import com.exceptions.ExceptionHandleExample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
