package com.BookStore.BookStoreManagement.authorservice.repository;

import com.BookStore.BookStoreManagement.authorservice.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
