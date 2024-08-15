package com.example.BookStoreManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CatrgoryDTO {
    private int categoryId; // Primary Key of the Category Entity
    // Category Entity has OneToMany Relationship with Book Entity
    private String categoryname;


}
