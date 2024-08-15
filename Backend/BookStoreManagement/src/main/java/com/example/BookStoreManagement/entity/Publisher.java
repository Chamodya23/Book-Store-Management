package com.example.BookStoreManagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Publisher")

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pub_Id;
    private String pub_Name;
    private String pub_Address;
}
