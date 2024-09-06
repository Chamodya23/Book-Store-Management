package com.BookStore.BookStoreManagement.CategoryService.controller;

import com.BookStore.BookStoreManagement.CategoryService.dto.CatrgoryDTO;
import com.BookStore.BookStoreManagement.CategoryService.service.implementation.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CategoryController handles all HTTP requests related to Category operations.
 * This includes creating, updating, retrieving, and deleting categories.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * Saves a new category to the database.
     *
     * @param catrgoryDTO The category data transfer object containing category details.
     * @return A ResponseEntity containing a success or error message and the appropriate HTTP status.
     */
    @PostMapping(value = "/saveCategory")
    public ResponseEntity<?> saveCategory(@RequestBody CatrgoryDTO catrgoryDTO) {
        try {
            String res = categoryService.saveCategory(catrgoryDTO);

            // Check if the category was successfully added or if it already exists
            if ("00".equals(res)) {
                return new ResponseEntity<>("Category Added Successfully!", HttpStatus.ACCEPTED);
            } else if ("06".equals(res)) {
                return new ResponseEntity<>("Category is Duplicated!", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Invalid Category Input!", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            // Handle any exceptions and return an internal server error status
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates an existing category in the database.
     *
     * @param catrgoryDTO The category data transfer object containing updated category details.
     * @return A ResponseEntity containing a success or error message and the appropriate HTTP status.
     */
    @PutMapping(value = "/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody CatrgoryDTO catrgoryDTO) {
        try {
            String res = categoryService.updateCategory(catrgoryDTO);

            // Check if the category was successfully updated or if it doesn't exist
            if ("00".equals(res)) {
                return new ResponseEntity<>("Category Updated Successfully!", HttpStatus.ACCEPTED);
            } else if ("06".equals(res)) {
                return new ResponseEntity<>("Not a Registered Category!", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Invalid Category Input!", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            // Handle any exceptions and return an internal server error status
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves all categories from the database.
     *
     * @return A ResponseEntity containing the list of categories and the appropriate HTTP status.
     */
    @GetMapping("/getAllCategory")
    public ResponseEntity<?> getAllCategory() {
        try {
            // Fetch the list of categories from the service
            List<CatrgoryDTO> catrgoryDTOList = categoryService.getAllCategory();

            // Return the list of categories with an accepted status
            return new ResponseEntity<>(catrgoryDTOList, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            // Handle any exceptions and return an internal server error status
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Searches for a specific category by its ID.
     *
     * @param categoryId The ID of the category to search for.
     * @return A ResponseEntity containing the category details or an error message and the appropriate HTTP status.
     */
    @GetMapping("/searchCategory/{categoryId}")
    public ResponseEntity<?> searchCategory(@PathVariable int categoryId) {
        try {
            // Search for the category by ID
            CatrgoryDTO catrgoryDTO = categoryService.searchCategory(categoryId);

            // Check if the category was found and return it or an error message
            if (catrgoryDTO != null) {
                return new ResponseEntity<>(catrgoryDTO, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("No Category Available for this categoryId.", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            // Handle any exceptions and return an internal server error status
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a specific category by its ID.
     *
     * @param categoryId The ID of the category to delete.
     * @return A ResponseEntity containing a success or error message and the appropriate HTTP status.
     */
    @DeleteMapping("deleteCategory/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable int categoryId) {
        try {
            // Attempt to delete the category by ID
            String res = categoryService.deleteCategory(categoryId);

            // Check if the category was successfully deleted or if it doesn't exist
            if ("00".equals(res)) {
                return new ResponseEntity<>("Category Deleted Successfully!", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("No Category Available for this category ID.", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            // Handle any exceptions and return an internal server error status
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
