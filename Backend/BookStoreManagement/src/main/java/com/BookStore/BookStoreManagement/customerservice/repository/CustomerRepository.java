package com.BookStore.BookStoreManagement.customerservice.repository;

import com.BookStore.BookStoreManagement.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
