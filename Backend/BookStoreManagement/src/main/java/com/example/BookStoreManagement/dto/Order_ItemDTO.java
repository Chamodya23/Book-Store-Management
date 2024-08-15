package com.example.BookStoreManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Order_ItemDTO {
    private int orderItemId;
    private int quantity;
    private float price;
}
