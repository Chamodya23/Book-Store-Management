package com.example.BookStoreManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDto {
    private int OrderId;
    private String OrderName;
    private int TotalAmount;

}
