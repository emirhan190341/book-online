package com.emirhanarici.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class BookDto {

    private String bookId;
    private String title;
    private int bookYear;
    private String author;
    private String pressName;


}
