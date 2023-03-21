package com.emirhanarici.bookservice.service;

import com.emirhanarici.bookservice.dto.BookDto;
import com.emirhanarici.bookservice.dto.BookIdDto;
import com.emirhanarici.bookservice.entity.Book;
import com.emirhanarici.bookservice.exception.BookNotFoundException;
import com.emirhanarici.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks() {

        return bookRepository.findAll()
                .stream()
                .map(BookDto::convertResponse)
                .collect(Collectors.toList());

    }

    public BookIdDto findByIsbn(String isbn) {

        return bookRepository.getBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: " + isbn));
    }

    public BookDto findBookDetailsById(String id) {

        return bookRepository.findById(id)
                .map(BookDto::convertResponse)
                .orElseThrow(() -> new BookNotFoundException("Book could not found by id: " + id));
    }


}
