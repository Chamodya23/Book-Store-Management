package com.BookStore.BookStoreManagement.authorservice.controller;

import com.BookStore.BookStoreManagement.authorservice.dto.AuthorDTO;
import com.BookStore.BookStoreManagement.authorservice.service.AuthorService;
import com.BookStore.BookStoreManagement.authorservice.util.VariableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * Save a new author to the database.
     * This method handles the POST request for saving a new author.
     *
     * @param authorDTO The data transfer object containing author details.
     * @return A response entity containing the result of the save operation.
     */
    @PostMapping(value = "/saveAuthor")
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorDTO authorDTO) {
        try {
            String res = authorService.saveAuthor(authorDTO);
            if (res.equals("00")) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success: Author added successfully.");
            } else if (res.equals("06")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Author Registered: Duplicate author.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Could not save author.");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + ex.getMessage());
        }
    }

    /**
     * Update an existing author in the database.
     * This method handles the PUT request to update an author's details.
     *
     * @param authorDTO The data transfer object containing updated author details.
     * @return A response entity containing the result of the update operation.
     */
    @PutMapping(value = "/updateAuthor")
    public ResponseEntity<String> updateAuthor(@RequestBody AuthorDTO authorDTO) {
        try {
            String res = authorService.updateAuthor(authorDTO);
            if (res.equals("00")) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success: Author updated successfully.");
            } else if (res.equals("01")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not A Registered Author.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Could not update author.");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + ex.getMessage());
        }
    }

    /**
     * Get a list of all authors from the database.
     * This method handles the GET request to retrieve all authors.
     *
     * @return A response entity containing a list of authors.
     */
    @GetMapping("/getAllAuthors")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        try {
            List<AuthorDTO> authorDTOList = authorService.getAllAuthor();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorDTOList);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Search for an author by their ID.
     * This method handles the GET request to retrieve an author by their ID.
     *
     * @param author_ID The ID of the author to search for.
     * @return A response entity containing the author details if found, otherwise a "not found" response.
     */
    @GetMapping("/searchAuthor/{author_ID}")
    public ResponseEntity<?> searchAuthor(@PathVariable int author_ID) {
        try {
            AuthorDTO authorDTO = authorService.searchAuthor(author_ID);
            if (authorDTO != null) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Author Available For this author_ID.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    /**
     * Delete an author by their ID.
     * This method handles the DELETE request to remove an author from the database.
     *
     * @param author_ID The ID of the author to delete.
     * @return A response entity indicating the result of the delete operation.
     */
    @DeleteMapping("/deleteAuthor/{author_ID}")
    public ResponseEntity<String> deleteAuthor(@PathVariable int author_ID) {
        try {
            String res = authorService.deleteAuthor(author_ID);
            if (res.equals("00")) {
                return ResponseEntity.status(HttpStatus.OK).body("Author Deleted Successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Author Available For this author_ID.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
