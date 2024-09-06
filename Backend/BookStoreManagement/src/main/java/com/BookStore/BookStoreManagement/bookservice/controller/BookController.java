package com.BookStore.BookStoreManagement.bookservice.controller;

import com.BookStore.BookStoreManagement.bookservice.dto.BookDTO;
import com.BookStore.BookStoreManagement.bookservice.service.BookServiceImpl;
import com.BookStore.BookStoreManagement.bookservice.util.VariableList;
import com.BookStore.BookStoreManagement.bookservice.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookController handles HTTP requests for managing books in the Bookstore Management System.
 * It provides REST API endpoints for saving, updating, retrieving, searching, and deleting books.
 */
@CrossOrigin // Enables Cross-Origin Resource Sharing (CORS) support
@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookServiceImpl BookService;

    @Autowired
    private ResponseDTO responseDTO;

    /**
     * POST /savebook
     * This method saves a new book in the system.
     *
     * @param bookDTO The book data to be saved.
     * @return ResponseEntity containing a success message if saved or an error message if failed.
     */
    @PostMapping(value = "/savebook")
    public ResponseEntity savebook(@RequestBody BookDTO bookDTO){
        System.out.println("Received bookDTO: " + bookDTO.toString());
        try {
            String res = BookService.saveBook(bookDTO); // Call the service to save the book
            if (res.equals("00")) {
                responseDTO.setCode(VariableList.RESPONSE_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(bookDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED); // Return success response
            } else if (res.equals("06")) { // Check if the book is already registered
                responseDTO.setCode(VariableList.RESPONSE_DUPLICATED);
                responseDTO.setMessage("Book Registered");
                responseDTO.setContent(bookDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST); // Return book already registered
            } else {
                responseDTO.setCode(VariableList.RESPONSE_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST); // Return error response
            }
        } catch (Exception ex) {
            responseDTO.setCode(VariableList.RESPONSE_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR); // Return exception response
        }
    }

    /**
     * PUT /updatebook/{bookId}
     * This method updates the details of an existing book.
     *
     * @param bookDTO The updated book data.
     * @return ResponseEntity containing a success message if updated or an error message if failed.
     */
    @PutMapping(value = "/updatebook/{bookId}")
    public ResponseEntity updatebook(@RequestBody BookDTO bookDTO) {
        try {
            String res = BookService.updateBook(bookDTO); // Call the service to update the book
            if (res.equals("00")) {
                responseDTO.setCode(VariableList.RESPONSE_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(bookDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED); // Return success response
            } else if (res.equals("01")) {
                responseDTO.setCode(VariableList.RESPONSE_DUPLICATED);
                responseDTO.setMessage("Not a Registered Book");
                responseDTO.setContent(bookDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST); // Return not registered book response
            } else {
                responseDTO.setCode(VariableList.RESPONSE_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST); // Return error response
            }
        } catch (Exception ex) {
            responseDTO.setCode(VariableList.RESPONSE_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR); // Return exception response
        }
    }

    /**
     * GET /getAllBooks
     * This method retrieves all books from the system.
     *
     * @return ResponseEntity containing the list of books.
     */
    @GetMapping("/getAllBooks")
    public ResponseEntity getAllBooks() {
        try {
            List<BookDTO> BookDTOList = BookService.getAllBooks(); // Call the service to get all books
            responseDTO.setCode(VariableList.RESPONSE_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(BookDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED); // Return success response
        } catch (Exception ex) {
            responseDTO.setCode(VariableList.RESPONSE_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR); // Return exception response
        }
    }

    /**
     * GET /searchBook/{bookId}
     * This method searches for a book by its ID.
     *
     * @param bookId The ID of the book to search for.
     * @return ResponseEntity containing the book details if found, or a no data message if not found.
     */
    @GetMapping("/searchBook/{bookId}")
    public ResponseEntity searchBook(@PathVariable int bookId) {
        try {
            BookDTO bookDTO = BookService.searchBook(bookId); // Call the service to search the book
            if (bookDTO != null) {
                responseDTO.setCode(VariableList.RESPONSE_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(bookDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED); // Return success response
            } else {
                responseDTO.setCode(VariableList.RESPONSE_NO_DATA_FOUND);
                responseDTO.setMessage("No Book Available For this BookID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST); // Return no data found response
            }
        } catch (Exception e) {
            responseDTO.setCode(VariableList.RESPONSE_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR); // Return exception response
        }
    }

    /**
     * DELETE /deleteBook/{bookId}
     * This method deletes a book by its ID.
     *
     * @param bookId The ID of the book to delete.
     * @return ResponseEntity containing a success message if deleted or an error message if not found.
     */
    @DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity deleteBook(@PathVariable int bookId) {
        try {
            String res = BookService.deleteBook(bookId); // Call the service to delete the book
            if (res.equals("00")) {
                responseDTO.setCode(VariableList.RESPONSE_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED); // Return success response
            } else {
                responseDTO.setCode(VariableList.RESPONSE_NO_DATA_FOUND);
                responseDTO.setMessage("No Book Available For this BookID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST); // Return no data found response
            }
        } catch (Exception e) {
            responseDTO.setCode(VariableList.RESPONSE_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR); // Return exception response
        }
    }
}
