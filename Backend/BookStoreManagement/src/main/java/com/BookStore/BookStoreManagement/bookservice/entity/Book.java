package com.BookStore.BookStoreManagement.bookservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Book entity represents the book details in the Bookstore Management System.
 * It is mapped to the 'Book' table in the database.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Book") // Specifies the name of the database table
public class Book {

    /**
     * The unique identifier for a book.
     * This field is automatically generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId; // Maps to book_id in the database

    /**
     * The title of the book.
     */
    private String title;

    /**
     * The International Standard Book Number (ISBN) of the book.
     */
    private String isbn;

    /**
     * The price of the book.
     * The 'double' type is used for accurate monetary value representation.
     */
    private double price;

    /**
     * The published date of the book.
     * Represented as a String.
     */
    private String publishedDate;
}
