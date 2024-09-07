package com.BookStore.BookStoreManagement.authorservice.service;

import com.BookStore.BookStoreManagement.authorservice.dto.AuthorDTO;
import com.BookStore.BookStoreManagement.authorservice.entity.Author;
import com.BookStore.BookStoreManagement.authorservice.repository.AuthorRepository;
import com.BookStore.BookStoreManagement.authorservice.util.VariableList;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;

import static com.BookStore.BookStoreManagement.authorservice.dto.AuthorDTO.getAuthor_ID;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Saves a new author to the database. If an author with the same ID already exists,
     * it returns a response indicating duplication. Otherwise, it saves the author.
     *
     * @param authorDTO The data transfer object for the author to be saved.
     * @return A string indicating success or duplication of the author.
     */
    @Override
    public String saveAuthor(AuthorDTO authorDTO) {
        // Use instance method to get ID
        if (authorRepository.existsById(getAuthor_ID())) {
            return VariableList.RESPONSE_DUPLICATED;
        } else {
            authorRepository.save(modelMapper.map(authorDTO, Author.class));
            return VariableList.RESPONSE_SUCCESS;
        }
    }

    /**
     * Updates an existing author. If the author with the given ID exists,
     * it updates the author's details. Otherwise, it returns a "no data found" response.
     *
     * @param authorDTO The data transfer object for the author to be updated.
     * @return A string indicating success or failure of the update.
     */
    @Override
    public String updateAuthor(AuthorDTO authorDTO) {
        // Check if the author with the given ID exists
        if (authorRepository.existsById(getAuthor_ID())) {
            // Update the author if it exists
            authorRepository.save(modelMapper.map(authorDTO, Author.class));
            return VariableList.RESPONSE_SUCCESS;
        } else {
            return VariableList.RESPONSE_NO_DATA_FOUND;
        }
    }

    /**
     * Retrieves all authors from the database and maps them to AuthorDTO objects.
     *
     * @return A list of AuthorDTO objects representing all authors in the database.
     */
    @Override
    public List<AuthorDTO> getAllAuthor() {
        // Retrieve all authors from the repository
        List<Author> authorList = authorRepository.findAll();
        // Convert the list of authors to a list of AuthorDTOs using ModelMapper
        return modelMapper.map(authorList, new TypeToken<ArrayList<AuthorDTO>>() {
        }.getType());
    }

    /**
     * Searches for an author by their ID. If the author exists, it returns the
     * corresponding AuthorDTO object, otherwise, it returns null.
     *
     * @param author_ID The ID of the author to search for.
     * @return The AuthorDTO object if found, otherwise null.
     */
    @Override
    public AuthorDTO searchAuthor(int author_ID) {
        // Check if the author with the given ID exists
        if (authorRepository.existsById(author_ID)) {
            // Retrieve the author if it exists and map to AuthorDTO
            Author author = authorRepository.findById(author_ID).orElse(null);
            return modelMapper.map(author, AuthorDTO.class);
        } else {
            return null;
        }
    }

    /**
     * Deletes an author by their ID. If the author exists, it deletes the author
     * and returns a success response. Otherwise, it returns a "no data found" response.
     *
     * @param author_ID The ID of the author to be deleted.
     * @return A string indicating success or failure of the deletion.
     */
    @Override
    public String deleteAuthor(int author_ID) {
        // Check if the author with the given ID exists
        if (authorRepository.existsById(author_ID)) {
            // Delete the author if it exists
            authorRepository.deleteById(author_ID);
            return VariableList.RESPONSE_SUCCESS;
        } else {
            return VariableList.RESPONSE_NO_DATA_FOUND;
        }
    }
}
