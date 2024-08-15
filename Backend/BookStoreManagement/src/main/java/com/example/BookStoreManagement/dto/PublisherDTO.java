package com.example.BookStoreManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PublisherDTO {
    private int pub_Id;
    private String pub_Name;
    private String pub_Address;
}
