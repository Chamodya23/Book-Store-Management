package com.BookStore.BookStoreManagement.publisherservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity class representing the Publisher in the database.
 * This class maps to the "Publisher" table in the database.
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Publisher")

public class Publisher {

    /**
     * Unique identifier for the publisher.
     * This serves as the primary key, with values generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisher_Id;//primary key

    /**
     * Name of the publisher.
     */
    private String publisher_Name;//name of publisher
    /**
     * Address of the publisher.
     */
    private String publisher_Address;//publisher's address
}



