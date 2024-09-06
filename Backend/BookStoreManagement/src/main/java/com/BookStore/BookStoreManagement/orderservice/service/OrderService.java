package com.BookStore.BookStoreManagement.orderservice.service;
import com.BookStore.BookStoreManagement.orderservice.dto.OrderDto;
import java.util.List;
public interface OrderService {
    String saveOrder(OrderDto orderdto);
    String updateOrder(OrderDto orderDto);
    List<OrderDto> getAllOrder();
    OrderDto searchOrder(int OrderID);
    String deleteOrder(int OrderID);
}