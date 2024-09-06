package com.BookStore.BookStoreManagement.publisherservice.repository;

import com.BookStore.BookStoreManagement.publisherservice.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Publisher entity.
 * This interface provides CRUD operations for Publisher entities
 * by extending the JpaRepository interface.
 *
 * JpaRepository provides methods for common database operations,
 * such as saving, deleting, and finding entities by ID.
 */

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}

