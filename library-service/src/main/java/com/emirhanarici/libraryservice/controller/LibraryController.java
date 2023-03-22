package com.emirhanarici.libraryservice.controller;

import com.emirhanarici.libraryservice.dto.AddBookRequest;
import com.emirhanarici.libraryservice.dto.LibraryDto;
import com.emirhanarici.libraryservice.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request) {
        libraryService.addBookToLibrary(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @GetMapping
    public ResponseEntity<List<String>> getAllLibraries() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libraryService.getAllLibraries());
    }


}
