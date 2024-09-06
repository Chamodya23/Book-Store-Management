package com.BookStore.BookStoreManagement.orderservice.repository;
import com.BookStore.BookStoreManagement.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
