package com.exceptions.ExceptionHandleExample.repository;

import com.exceptions.ExceptionHandleExample.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
