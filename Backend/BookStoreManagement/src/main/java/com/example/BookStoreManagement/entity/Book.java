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

    @ManyToOne
    @JoinColumn(name = "pub_Id", referencedColumnName = "pub_Id")
    private Publisher publisher; // Foreign Key referring to Publisher entity

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

}

