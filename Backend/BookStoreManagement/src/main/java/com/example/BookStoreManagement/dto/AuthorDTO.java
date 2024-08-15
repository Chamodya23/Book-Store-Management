package com.example.BookStoreManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDTO {
    public static int author_ID;
    private String author_Name;
    private String biography;

    public static Integer getauthor_ID() {
        return author_ID;
    }

    public static Integer author_ID() {
        return author_ID;
    }
}
