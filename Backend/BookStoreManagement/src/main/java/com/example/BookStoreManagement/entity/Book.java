package com.example.BookStoreManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @JoinColumn(name = "author_id", referencedColumnName = "author_ID")
    private Author author; // Foreign Key referring to Author entity

    @Column(name = "publisher_id")
    private int publisherId; // Foreign Key referring to Publisher entity

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryID")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Order_Item> orderItems;

}

