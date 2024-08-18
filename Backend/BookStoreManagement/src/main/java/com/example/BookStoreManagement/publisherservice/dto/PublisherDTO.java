package com.example.BookStoreManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PublisherDTO {
    private int pub_Id;//primary key
    private String pub_Name;//Publisher's Name
    private String pub_Address;//publisher's Address
}
