package com.emirhanarici.bookservice.dto;

import com.emirhanarici.bookservice.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String bookId;
    private String isbn;
    private String title;
    private int bookYear;
    private String author;
    private String pressName;


    public static BookDto convertResponse(Book book) {
        return BookDto.builder()
                .bookId(book.getId())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .bookYear(book.getBookYear())
                .author(book.getAuthor())
                .pressName(book.getPressName())
                .build();
    }

}
