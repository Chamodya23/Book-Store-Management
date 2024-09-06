package com.BookStore.BookStoreManagement.publisherservice.controller;

import com.BookStore.BookStoreManagement.publisherservice.dto.PublisherDTO;
import com.BookStore.BookStoreManagement.publisherservice.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    /**
     * Save a new publisher.
     *
     * @param publisherDTO The publisher data transfer object containing publisher details.
     * @return ResponseEntity containing the saved publisher and HTTP status.
     */
    @PostMapping(value = "/savePublisher")
    public ResponseEntity<?> savePublisher(@RequestBody PublisherDTO publisherDTO) {
        try {
            String res = publisherService.savePublisher(publisherDTO);
            if (res.equals("00")) {
                // Publisher saved successfully
                return new ResponseEntity<>(publisherDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                // Publisher is already registered
                return new ResponseEntity<>("Publisher Registered", HttpStatus.BAD_REQUEST);
            } else {
                // Some error occurred
                return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            // Handle any exceptions that occur
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update an existing publisher.
     *
     * @param publisherDTO The publisher data transfer object containing updated details.
     * @return ResponseEntity containing the updated publisher and HTTP status.
     */
    @PutMapping(value = "/updatePublisher")
    public ResponseEntity<?> updatePublisher(@RequestBody PublisherDTO publisherDTO) {
        try {
            String res = publisherService.updatePublisher(publisherDTO);
            if (res.equals("00")) {
                // Publisher updated successfully
                return new ResponseEntity<>(publisherDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                // Publisher is not registered
                return new ResponseEntity<>("Not A Registered Publisher", HttpStatus.BAD_REQUEST);
            } else {
                // Some error occurred
                return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            // Handle any exceptions that occur
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all publishers.
     *
     * @return ResponseEntity containing a list of all publishers and HTTP status.
     */
    @GetMapping("/getAllPublishers")
    public ResponseEntity<?> getAllPublishers() {
        try {
            // Fetch the list of all publishers
            List<PublisherDTO> publisherDTOList = publisherService.getAllPublisher();
            return new ResponseEntity<>(publisherDTOList, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            // Handle any exceptions that occur
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Search for a publisher by ID.
     *
     * @param publisher_Id The ID of the publisher to search for.
     * @return ResponseEntity containing the found publisher or an error message and HTTP status.
     */
    @GetMapping("/searchPublisher/{publisher_Id}")
    public ResponseEntity<?> searchPublisher(@PathVariable int publisher_Id) {
        try {
            // Search for the publisher by ID
            PublisherDTO publisherDTO = publisherService.searchPublisher(publisher_Id);
            if (publisherDTO != null) {
                // Publisher found
                return new ResponseEntity<>(publisherDTO, HttpStatus.ACCEPTED);
            } else {
                // No publisher found with the given ID
                return new ResponseEntity<>("No Publisher Available For this publisher_Id", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Handle any exceptions that occur
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete a publisher by ID.
     *
     * @param publisher_Id The ID of the publisher to delete.
     * @return ResponseEntity containing a success message or an error message and HTTP status.
     */
    @DeleteMapping("/deletePublisher/{publisher_Id}")
    public ResponseEntity<?> deletePublisher(@PathVariable int publisher_Id) {
        try {
            // Attempt to delete the publisher by ID
            String res = publisherService.deletePublisher(publisher_Id);
            if (res.equals("00")) {
                // Publisher deleted successfully
                return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
            } else {
                // No publisher found with the given ID
                return new ResponseEntity<>("No Publisher Available For this publisher_Id", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Handle any exceptions that occur
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

