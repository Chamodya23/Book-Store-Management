package com.BookStore.BookStoreManagement.authorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * ResponseDTO is a Data Transfer Object (DTO) used to encapsulate the structure of a standard response
 * for API requests. It contains a response code, message, and an optional content object, which can hold
 * any data relevant to the response.
 */
@Component
@AllArgsConstructor  // Generates a constructor with arguments for all fields
@NoArgsConstructor   // Generates a default no-args constructor
@Data                // Generates getters, setters, toString, equals, and hashCode methods
public class ResponseDTO {

    /**
     * A string representing the response code.
     * This can indicate success, failure, or any other status as per business logic.
     */
    private String code;

    /**
     * A message providing additional information about the response,
     * such as "Success", "Error", or detailed error messages.
     */
    private String message;

    /**
     * An object representing the content of the response. This can hold any type of data,
     * such as a list of authors, details of an author, or null in case of errors.
     */
    private Object content;

}
