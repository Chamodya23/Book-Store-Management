package com.BookStore.BookStoreManagement.orderservice.service;
import com.BookStore.BookStoreManagement.orderservice.entity.Order;
import com.BookStore.BookStoreManagement.orderservice.dto.OrderDto;
import com.BookStore.BookStoreManagement.orderservice.repository.OrderRepository;
import com.BookStore.BookStoreManagement.orderservice.util.VariableList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    // Corrected the naming convention to start with a lowercase letter
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveOrder(OrderDto orderDto) {
        // Use the corrected repository variable name
        if (orderRepository.existsById(orderDto.getOrderId())) {
            return VariableList.RSP_DUPLICATED;
        } else {
            orderRepository.save(modelMapper.map(orderDto, Order.class));
            return VariableList.RSP_SUCCESS;
        }
    }

    @Override
    public String updateOrder(OrderDto orderDto) {
        // Use the corrected repository variable name
        if (orderRepository.existsById(orderDto.getOrderId())) {
            orderRepository.save(modelMapper.map(orderDto, Order.class));
            return VariableList.RSP_SUCCESS;
        } else {
            return VariableList.RSP_NO_DATA_FOUND;
        }
    }

    @Override
    public List<OrderDto> getAllOrder() {
        // Use the corrected repository variable name
        List<Order> orderList = orderRepository.findAll();
        return modelMapper.map(orderList, new TypeToken<ArrayList<OrderDto>>() {}.getType());
    }

    @Override
    public OrderDto searchOrder(int orderID) {
        // Corrected method parameter naming convention to lowercase 'orderID'
        if (orderRepository.existsById(orderID)) {
            Order order = orderRepository.findById(orderID).orElse(null);
            return modelMapper.map(order, OrderDto.class);
        } else {
            return null;
        }
    }

    @Override
    public String deleteOrder(int orderID) {
        // Corrected method parameter naming convention to lowercase 'orderID'
        if (orderRepository.existsById(orderID)) {
            orderRepository.deleteById(orderID);
            return VariableList.RSP_SUCCESS;
        } else {
            return VariableList.RSP_NO_DATA_FOUND;
        }
    }
}
