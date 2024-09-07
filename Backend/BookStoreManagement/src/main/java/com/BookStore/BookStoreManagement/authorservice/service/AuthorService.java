package com.BookStore.BookStoreManagement.authorservice.service;

import com.BookStore.BookStoreManagement.authorservice.dto.AuthorDTO;

import java.util.List;

/**
 * Service interface for managing authors in the BookStore application.
 * Provides methods for creating, updating, retrieving, and deleting authors.
 */
public interface AuthorService {

    String saveAuthor(AuthorDTO authorDTO);

    String updateAuthor(AuthorDTO authorDTO);

    List<AuthorDTO> getAllAuthor();

    AuthorDTO searchAuthor(int author_ID);

    String deleteAuthor(int author_ID);
}
