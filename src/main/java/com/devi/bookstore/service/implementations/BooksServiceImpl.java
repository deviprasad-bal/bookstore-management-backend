package com.devi.bookstore.service.implementations;

import com.devi.bookstore.dao.interfaces.AuthorsDAO;
import com.devi.bookstore.dao.interfaces.BooksDAO;
import com.devi.bookstore.dto.AddBookDTO;
import com.devi.bookstore.dto.AddBookDetailsDTO;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.service.interfaces.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksDAO booksdao;

    @Autowired
    private AuthorsDAO authorsDAO;

    @Transactional
    @Override
    public List<Books> get() {
        return booksdao.get();
    }

    @Transactional
    @Override
    @Cacheable(value = "books", key = "#id")
    public Books get(int id) {
        return booksdao.get(id);
    }

    @Transactional
    @Override
    @CachePut(value = "books", key = "#result.id")
    public Books save(AddBookDTO addBookDTO) {
        return booksdao.save(addBookDTO);
    }

    @Transactional
    @Override
    @CacheEvict(value = "books", key = "#id")
    public void delete(int id) {
        booksdao.delete(id);
    }

    @Transactional
    @Override
    @Cacheable(value = "books", key = "#query")
    public Optional<Books> searchBooks(String query) {
        return booksdao.searchBooks(query);
    }

    @Transactional
    @Override
    @CacheEvict(value = "books", allEntries = true)
    public Books saveBookWithDetails(AddBookDetailsDTO addBookDetailsDTO) {
        return booksdao.saveBookWithDetails(addBookDetailsDTO);
    }
}