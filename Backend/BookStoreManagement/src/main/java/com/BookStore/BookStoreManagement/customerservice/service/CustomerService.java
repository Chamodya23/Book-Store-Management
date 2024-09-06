package com.BookStore.BookStoreManagement.customerservice.service;

import com.BookStore.BookStoreManagement.customerservice.entity.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    /**
     * Saves a new customer.
     * @param customer  The Customer object to be saved.
     * @return ResponseEntity containing the response message
     */
    ResponseEntity<?> saveCustomer(Customer customer);

    /**
     * Retrieves all customers.
     * @return ResponseEntity containing the response message
     */

    ResponseEntity<?> viewCustomer();

    /**
     *  Updates an existing customer's details.
     * @param newCustomer The Customer object with updated details.
     * @param id The ID of the customer to be updated
     * @return ResponseEntity containing the response message
     */

    ResponseEntity<?> updateCustomer(Customer newCustomer, Integer id);

    /**
     * Deletes a customer by ID.
     * @param id he ID of the customer to be deleted.
     * @return ResponseEntity containing the response message
     */

    ResponseEntity<?> deleteCustomer(Integer id);

    /**
     * Searches for a customer by ID
     * @param id The ID of the customer to be searched.
     * @return ResponseEntity containing the response message
     */

    ResponseEntity<?> searchCustomer(Integer id);
}
