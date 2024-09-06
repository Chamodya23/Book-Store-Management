package com.BookStore.BookStoreManagement.authorservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_ID;
    private String author_Name;
    private String biography;

    //One author can write many books
  //  @OneToMany(mappedBy = "author")
  // private List<Book> books;  // Ensure you have a Book entity
}
