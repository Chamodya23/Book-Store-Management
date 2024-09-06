package com.BookStore.BookStoreManagement.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BookDTO is a data transfer object used to transfer book-related data between the client and server.
 * It represents the details of a book in the system.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookDTO {

    /**
     * The unique identifier for the book. This serves as the primary key in the Book entity.
     */
    private int bookId;

    /**
     * The title of the book.
     */
    private String title;

    /**
     * The ISBN (International Standard Book Number) of the book.
     */
    private String isbn;

    /**
     * The price of the book.
     */
    private double price;

    /**
     * The published date of the book in string format (could be formatted as yyyy-mm-dd).
     */
    private String publishedDate;

    /**
     * The identifier for the author of the book.
     * This is a foreign key referring to the Author entity.
     */
    private int authorId;

    /**
     * The identifier for the publisher of the book.
     * This is a foreign key referring to the Publisher entity.
     */
    private int publisherId;

    /**
     * The identifier for the category to which the book belongs.
     * This is a foreign key referring to the Category entity.
     */
    private int categoryId;
}
