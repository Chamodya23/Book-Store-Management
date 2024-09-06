package com.BookStore.BookStoreManagement.bookservice.service;

import com.BookStore.BookStoreManagement.bookservice.dto.BookDTO;
import java.util.List;

public interface BookService {

    /**
     * Saves a new book in the system.
     *
     * @param bookDTO The data of the book to be saved.
     * @return A response code indicating the result of the save operation.
     *         - "00" for success
     *         - "06" for a book that is already registered
     *         - Other codes for failure
     */
    String saveBook(BookDTO bookDTO);

    /**
     * Updates the details of an existing book in the system.
     *
     * @param bookDTO The updated book data.
     * @return A response code indicating the result of the update operation.
     *         - "00" for success
     *         - "01" if the book is not registered
     *         - Other codes for failure
     */
    String updateBook(BookDTO bookDTO);

    /**
     * Retrieves all books from the system.
     *
     * @return A list of all books available in the system.
     */
    List<BookDTO> getAllBooks();

    /**
     * Searches for a book by its ID.
     *
     * @param bookId The ID of the book to search for.
     * @return The book data if found, or null if the book is not found.
     */
    BookDTO searchBook(int bookId);

    /**
     * Deletes a book from the system by its ID.
     *
     * @param bookId The ID of the book to delete.
     * @return A response code indicating the result of the delete operation.
     *         - "00" for success
     *         - Other codes if the book is not found or the operation fails
     */
    String deleteBook(int bookId);
}
