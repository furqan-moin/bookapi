package com.furqan.bookapi.controller;

import com.furqan.Dto.BookRequestDto;
import com.furqan.Dto.BookResponseDto;
import com.furqan.bookapi.service.BookService;
import com.furqan.entity.Book;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> findAllBooks() {
        return ResponseEntity.ok(service.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(
            @Valid @RequestBody BookRequestDto requestDto) {
        return new ResponseEntity<>(
                service.addBook(requestDto),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookRequestDto requestDto) {
        return ResponseEntity.ok(
                service.updateBook(id, requestDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
