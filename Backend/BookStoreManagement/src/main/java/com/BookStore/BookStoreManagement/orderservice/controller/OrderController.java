package com.BookStore.BookStoreManagement.orderservice.controller;

import com.BookStore.BookStoreManagement.orderservice.dto.OrderDto;
import com.BookStore.BookStoreManagement.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "saveOrder")
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto) {
        try {
            String res = orderService.saveOrder(orderDto);
            if (res.equals("00")) {
                return new ResponseEntity<>(orderDto, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                return new ResponseEntity<>("Order already registered", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Error occurred", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "UpdateOrder")
    public ResponseEntity<?> updateOrder(@RequestBody OrderDto orderDto) {
        try {
            String res = orderService.updateOrder(orderDto);
            if (res.equals("00")) {
                return new ResponseEntity<>(orderDto, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                return new ResponseEntity<>("Order is not registered", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Error occurred", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrders() {
        try {
            List<OrderDto> orderDtoList = orderService.getAllOrder();
            if (orderDtoList.isEmpty()) {
                return new ResponseEntity<>("No orders found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(orderDtoList, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            ex.printStackTrace();  // This will help in identifying the issue
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/SearchOrder/{OrderID}")
    public ResponseEntity<?> searchOrder(@PathVariable int OrderID) {
        try {
            OrderDto orderDto = orderService.searchOrder(OrderID);
            if (orderDto != null) {
                return new ResponseEntity<>(orderDto, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("No order available for this OrderID", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeleteOrder/{OrderID}")
    public ResponseEntity<?> deleteOrder(@PathVariable int OrderID) {
        try {
            String res = orderService.deleteOrder(OrderID);
            if (res.equals("00")) {
                return new ResponseEntity<>("Order deleted successfully", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("No order available for this OrderID", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
