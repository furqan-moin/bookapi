package com.furqan.bookapi.service;

import com.furqan.Dto.BookRequestDto;
import com.furqan.Dto.BookResponseDto;
import com.furqan.bookapi.exception.ResourceNotFoundException;
import com.furqan.bookapi.repository.BookRepository;
import com.furqan.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookResponseDto> findAllBooks() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    public BookResponseDto getBookById(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with ID: " + id));

        return mapToResponseDto(book);
    }

    public BookResponseDto addBook(BookRequestDto requestDto) {

        Book book = new Book();

        book.setTitle(requestDto.getTitle());
        book.setAuthor(requestDto.getAuthor());
        book.setPrice(requestDto.getPrice());

        Book savedBook = repository.save(book);

        return mapToResponseDto(savedBook);
    }

    public BookResponseDto updateBook(Long id, BookRequestDto requestDto) {

        Book existingBook = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with ID: " + id));

        existingBook.setTitle(requestDto.getTitle());
        existingBook.setAuthor(requestDto.getAuthor());
        existingBook.setPrice(requestDto.getPrice());

        Book updatedBook = repository.save(existingBook);

        return mapToResponseDto(updatedBook);
    }

    public void deleteBook(Long id) {

        Book existingBook = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with ID: " + id));

        repository.delete(existingBook);
    }

    private BookResponseDto mapToResponseDto(Book book) {

        BookResponseDto dto = new BookResponseDto();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());

        return dto;
    }
}