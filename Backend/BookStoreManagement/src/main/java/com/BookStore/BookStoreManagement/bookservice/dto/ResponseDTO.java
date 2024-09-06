package com.BookStore.BookStoreManagement.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * ResponseDTO is a data transfer object used to standardize the response
 * structure returned by the API. It contains a response code, message, and content.
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {

    /**
     * The response code representing the outcome of the API operation.
     * For example:
     * - "00" for success
     * - "01" or other codes for errors or specific statuses
     */
    private String code;

    /**
     * A message providing additional information about the response,
     * typically a success or error message.
     */
    private String message;

    /**
     * The content or data returned by the API, which can vary depending on the API call.
     * This could be a single object or a list of objects.
     */
    private Object content;
}
