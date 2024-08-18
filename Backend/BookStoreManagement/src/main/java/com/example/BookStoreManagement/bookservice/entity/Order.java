package com.example.BookStoreManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
<<<<<<< HEAD
@Table(name = "Orders ")
=======
@Table(name = "Orders")
>>>>>>> 98ca2fb8bad4f47d9012acbd040cea259df72936

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderId;
    private String OrderName;
    private int TotalAmount;

    @OneToMany(mappedBy = "order")
    private List<Order_Item> orderItems;
}
