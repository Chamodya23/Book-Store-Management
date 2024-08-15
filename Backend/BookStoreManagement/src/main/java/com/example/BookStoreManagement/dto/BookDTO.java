package com.example.BookStoreManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class BookDTO {
    private int book_Id; // Primary Key for Book entity
    private String title;
    private String isbn;
    private double price; // Price of the book
    private String publishedDate; // Published date of the book
    private int authorId; // Foreign Key referring to the Author entity
    private int pub_Id; // Foreign Key referring to the Publisher entity
    private int categoryId; // Foreign Key referring to the Category entity
}