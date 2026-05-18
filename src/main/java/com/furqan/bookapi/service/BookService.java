package com.furqan.bookapi.service;

import com.furqan.Dto.BookResponseDto;
import com.furqan.bookapi.exception.ResourceNotFoundException;
import com.furqan.bookapi.repository.BookRepository;
import com.furqan.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookResponseDto> findAllBooks() {
        return repository.findAll().stream().map(this :: mapToResponseDto).toList();
    }

    private BookResponseDto mapToResponseDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        return dto;
    }

    public BookResponseDto getBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
        return mapToResponseDto(book);
    }
    public Book addBook(Book book) {
        return repository.save(book);
    }
    public Book updateBook(Long id, Book updatedBook) {
        BookResponseDto existingBook = getBookById(id);
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());
        return repository.save(existingBook);
    }
    public void deleteBookById(Long id) {
        BookResponseDto existingBook = getBookById(id);
        repository.delete
                (existingBook);
    }

    public void deleteBook(Long id) {
            Book existingBook = repository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Book not found with ID: " + id));

            repository.delete(existingBook);
    }
}
