package com.furqan.bookapi.repository;

import com.furqan.Dto.BookResponseDto;
import com.furqan.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    void delete(BookResponseDto existingBook);
}
hi