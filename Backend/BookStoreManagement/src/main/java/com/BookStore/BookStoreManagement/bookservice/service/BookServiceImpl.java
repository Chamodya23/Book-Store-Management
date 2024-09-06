package com.BookStore.BookStoreManagement.bookservice.service;

import com.BookStore.BookStoreManagement.bookservice.dto.BookDTO;
import com.BookStore.BookStoreManagement.bookservice.entity.Book;
import com.BookStore.BookStoreManagement.bookservice.repository.BookRepository;
import com.BookStore.BookStoreManagement.bookservice.util.VariableList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Saves a new book in the system.
     *
     * @param bookDTO The data of the book to be saved.
     * @return A response code indicating the result of the save operation:
     *         - "00" for success
     *         - "06" if the book is already registered
     */
    @Override
    public String saveBook(BookDTO bookDTO) {
        if (bookRepository.existsById(bookDTO.getBookId())) {
            return VariableList.RESPONSE_DUPLICATED;
        } else {
            bookRepository.save(modelMapper.map(bookDTO, Book.class));
            return VariableList.RESPONSE_SUCCESS;
        }
    }

    /**
     * Updates the details of an existing book.
     *
     * @param bookDTO The updated book data.
     * @return A response code indicating the result of the update operation:
     *         - "00" for success
     *         - "01" if the book is not registered
     */
    @Override
    public String updateBook(BookDTO bookDTO) {
        if (bookRepository.existsById(bookDTO.getBookId())) {
            bookRepository.save(modelMapper.map(bookDTO, Book.class));
            return VariableList.RESPONSE_SUCCESS;
        } else {
            return VariableList.RESPONSE_NO_DATA_FOUND;
        }
    }

    /**
     * Retrieves all books from the system.
     *
     * @return A list of all books as BookDTO objects.
     */
    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return modelMapper.map(bookList, new TypeToken<ArrayList<BookDTO>>() {}.getType());
    }

    /**
     * Searches for a book by its ID.
     *
     * @param bookId The ID of the book to search for.
     * @return The BookDTO if the book is found, otherwise null.
     */
    @Override
    public BookDTO searchBook(int bookId) {
        if (bookRepository.existsById(bookId)) {
            Book book = bookRepository.findById(bookId).orElse(null);
            return modelMapper.map(book, BookDTO.class);
        } else {
            return null;
        }
    }

    /**
     * Deletes a book by its ID.
     *
     * @param bookId The ID of the book to delete.
     * @return A response code indicating the result of the delete operation:
     *         - "00" for success
     *         - "01" if the book is not found
     */
    @Override
    public String deleteBook(int bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return VariableList.RESPONSE_SUCCESS;
        } else {
            return VariableList.RESPONSE_NO_DATA_FOUND;
        }
    }
}
