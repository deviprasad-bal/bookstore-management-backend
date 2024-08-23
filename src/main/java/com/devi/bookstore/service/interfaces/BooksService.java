package com.devi.bookstore.service.interfaces;

import com.devi.bookstore.dto.AddBookDTO;
import com.devi.bookstore.dto.AddBookDetailsDTO;
import com.devi.bookstore.model.Books;

import java.util.List;
import java.util.Optional;

public interface BooksService {
    List<Books> get();

    Books get(int id);

    Books save(AddBookDTO addBookDTO);

    void delete(int id);

    Optional<Books> searchBooks(String query);

    Books saveBookWithDetails(AddBookDetailsDTO addBookDetailsDTO);
}