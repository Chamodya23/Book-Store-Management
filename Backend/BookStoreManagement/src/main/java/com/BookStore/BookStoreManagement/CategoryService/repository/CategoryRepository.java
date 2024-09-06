package com.BookStore.BookStoreManagement.CategoryService.repository;

import com.BookStore.BookStoreManagement.CategoryService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
