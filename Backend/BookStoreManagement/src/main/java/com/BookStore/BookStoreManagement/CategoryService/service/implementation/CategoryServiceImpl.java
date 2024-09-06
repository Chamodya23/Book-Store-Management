package com.BookStore.BookStoreManagement.CategoryService.service.implementation;

import com.BookStore.BookStoreManagement.CategoryService.dto.CatrgoryDTO;
import com.BookStore.BookStoreManagement.CategoryService.entity.Category;
import com.BookStore.BookStoreManagement.CategoryService.repository.CategoryRepository;
import com.BookStore.BookStoreManagement.CategoryService.service.CategoryService;
import com.BookStore.BookStoreManagement.CategoryService.util.ResponseList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for managing categories.
 * This class handles the core business logic for creating, updating,
 * retrieving, and deleting categories.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Saves a new category to the database.
     * If the category already exists, it returns a duplicated response.
     *
     * @param catrgoryDTO The category data transfer object containing category details.
     * @return A string indicating success or failure.
     */
    @Override
    public String saveCategory(CatrgoryDTO catrgoryDTO) {
        // Check if the category already exists
        if (categoryRepository.existsById(catrgoryDTO.getCategoryId())) {
            return ResponseList.RESPONSE_DUPLICATED;
        } else {
            // Save the new category
            categoryRepository.save(modelMapper.map(catrgoryDTO, Category.class));
            return ResponseList.RESPONSE_SUCCESS;
        }
    }

    /**
     * Updates an existing category in the database.
     * If the category does not exist, it returns a "no data found" response.
     *
     * @param catrgoryDTO The category data transfer object containing updated category details.
     * @return A string indicating success or failure.
     */
    @Override
    public String updateCategory(CatrgoryDTO catrgoryDTO) {
        // Check if the category exists
        if (categoryRepository.existsById(catrgoryDTO.getCategoryId())) {
            // Update the category
            categoryRepository.save(modelMapper.map(catrgoryDTO, Category.class));
            return ResponseList.RESPONSE_SUCCESS;
        } else {
            return ResponseList.RESPONSE_N0_DATA_FOUND;
        }
    }

    /**
     * Retrieves all categories from the database.
     *
     * @return A list of category data transfer objects.
     */
    @Override
    public List<CatrgoryDTO> getAllCategory() {
        // Fetch all categories and map them to DTOs
        List<Category> categoryList = categoryRepository.findAll();
        return modelMapper.map(categoryList, new TypeToken<ArrayList<CatrgoryDTO>>() {}.getType());
    }

    /**
     * Searches for a specific category by its ID.
     * If the category exists, it returns the corresponding DTO; otherwise, it returns null.
     *
     * @param categoryId The ID of the category to search for.
     * @return The category data transfer object or null if not found.
     */
    @Override
    public CatrgoryDTO searchCategory(int categoryId) {
        // Check if the category exists
        if (categoryRepository.existsById(categoryId)) {
            // Retrieve the category and map it to a DTO
            Category category = categoryRepository.findById(categoryId).orElse(null);
            return modelMapper.map(category, CatrgoryDTO.class);
        } else {
            return null;
        }
    }

    /**
     * Deletes a specific category by its ID.
     * If the category does not exist, it returns a "no data found" response.
     *
     * @param categoryId The ID of the category to delete.
     * @return A string indicating success or failure.
     */
    @Override
    public String deleteCategory(int categoryId) {
        // Check if the category exists
        if (categoryRepository.existsById(categoryId)) {
            // Delete the category by ID
            categoryRepository.deleteById(categoryId);
            return ResponseList.RESPONSE_SUCCESS;
        } else {
            return ResponseList.RESPONSE_N0_DATA_FOUND;
        }
    }
}
