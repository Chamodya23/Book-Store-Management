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
@Table(name = "Publisher")

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pub_Id;//primary key
    private String pub_Name;//name of publisher
    private String pub_Address;//publisher's address

    //One publisher can write many books
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;  // Ensure you have a Book entity
}


