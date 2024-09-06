package com.BookStore.BookStoreManagement.bookservice.repository;

import com.BookStore.BookStoreManagement.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
