package com.BookStore.BookStoreManagement.CategoryService.service;

import com.BookStore.BookStoreManagement.CategoryService.dto.CatrgoryDTO;

import java.util.List;

public interface CategoryService {
    String saveCategory(CatrgoryDTO catrgoryDTO);

    String updateCategory(CatrgoryDTO catrgoryDTO);

    List<CatrgoryDTO> getAllCategory();

    CatrgoryDTO searchCategory(int categoryId);

    String deleteCategory(int categoryId);

}



