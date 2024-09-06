package com.BookStore.BookStoreManagement.authorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing an author.
 * This class is used to transfer author data between different layers of the application.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDTO {

    /**
     * The unique identifier for the author.
     * This field is static, which implies it is shared among all instances of the class,
     * but this may not be the typical approach for an identifier.
     */
    public static int author_ID;
    private String author_Name;
    private String biography;

    /**
     * Gets the unique identifier of the author.
     * This method returns the static field author_ID.
     *
     * @return The unique identifier of the author.
     */


    public static Integer getAuthor_ID() {
        return author_ID;
    }
}
