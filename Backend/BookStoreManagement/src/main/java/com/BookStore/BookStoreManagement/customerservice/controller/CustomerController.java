package com.BookStore.BookStoreManagement.customerservice.controller;


import com.BookStore.BookStoreManagement.customerservice.entity.Customer;
import com.BookStore.BookStoreManagement.customerservice.service.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService; //inject the CustomerService implementation

    /**
     * Endpoint to save a new customer
     * @param customer the Customer object to be saved
     * @return ResponseEntity contain the result of save operation
     */
    @PostMapping("/save")

    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer)
    {
        return customerService.saveCustomer(customer); //The save operation is delegated to the service layer
    }

    /**
     *Endpoint to retrieve all customers
     * @return ResponseEntity containing the list of all customers
     */
    @GetMapping ("/view")
    public ResponseEntity<?> viewCustomer()
    {
        return customerService.viewCustomer(); // calls the service to fetch all customers
    }

    /**
     * Endpoint to update an existing customer's details
     * @param customer the customer object with updated details
     * @param id the id of the customer to be updated
     * @return ResponseEntity contain the result of the update operation
     */

    @PutMapping ("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer,@RequestParam Integer id)
    {
        return customerService.updateCustomer(customer,id); //Updates customer details based on the given id
    }

    /**
     * Endpoint to delete a customer by id
     * @param id the id of the customer to be deleted
     * @return ResponseEntity contain the result of the delete operation
     */

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCustomer(@RequestParam Integer id)
    {
        return customerService.deleteCustomer(id); //Deletes a customer based on the given id
    }

    /**
     * Endpoint to search for a customer by id
     * @param id the id of the customer to be searched
     * @return ResponseEntity contain the found customer
     */

    @GetMapping ("/search")
    public ResponseEntity<?> searchCustomer(@RequestParam Integer id)
    {
        return customerService.searchCustomer(id); //Searches for a customer by the given id
    }
}

