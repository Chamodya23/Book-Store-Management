package com.BookStore.BookStoreManagement.publisherservice.service;

import com.BookStore.BookStoreManagement.publisherservice.dto.PublisherDTO;
import java.util.List;

/**
 * Service interface for managing publishers.
 * Provides methods for saving, updating, retrieving, and deleting publishers.
 */

public interface PublisherService {

    /**
     * Save a new publisher in the system.
     *
     * @param publisherDTO the publisher data to be saved
     * @return a response code indicating success or duplication
     */
    String savePublisher(PublisherDTO publisherDTO);
    /**
     * Update an existing publisher in the system.
     *
     * @param publisherDTO the updated publisher data
     * @return a response code indicating success or no data found
     */
    String updatePublisher(PublisherDTO publisherDTO);
    /**
     * Retrieve all publishers from the system.
     *
     * @return a list of PublisherDTOs representing all publishers
     */
    List<PublisherDTO> getAllPublisher();
    /**
     * Search for a specific publisher by their ID.
     *
     * @param publisher_Id the ID of the publisher to search for
     * @return a PublisherDTO representing the found publisher or null if not found
     */
    PublisherDTO searchPublisher(int publisher_Id);

    /**
     * Delete a publisher from the system by their ID.
     *
     * @param publisher_Id the ID of the publisher to be deleted
     * @return a response code indicating success or no data found
     */
    String deletePublisher(int publisher_Id);
}