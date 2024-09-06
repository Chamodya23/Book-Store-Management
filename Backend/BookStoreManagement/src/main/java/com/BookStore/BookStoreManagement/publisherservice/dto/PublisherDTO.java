package com.BookStore.BookStoreManagement.publisherservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for Publisher.
 * This class is used to transfer publisher-related data between different layers of the application.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PublisherDTO {
    /**
     * Unique identifier for the publisher.
     * This serves as the primary key.
     */
    private int publisher_Id;//primary key
    /**
     * Name of the publisher.
     */
    private String publisher_Name;//Publisher's Name
    /**
     * Address of the publisher.
     */
    private String publisher_Address;//publisher's Address
}
