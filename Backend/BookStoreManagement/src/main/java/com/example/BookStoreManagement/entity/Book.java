package com.example.BookStoreManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId; // book_id in the database
    private String title;
    private String isbn;
    private double price; // Changed to double for better monetary value representation
    private String publishedDate; // Changed to String for date representation

    @Column(name = "author_id")
    private int authorId; // Foreign Key referring to Author entity

    @Column(name = "publisher_id")
    private int publisherId; // Foreign Key referring to Publisher entity

    @Column(name = "category_id")
    private int categoryId; // Foreign Key referring to Category entity

}

