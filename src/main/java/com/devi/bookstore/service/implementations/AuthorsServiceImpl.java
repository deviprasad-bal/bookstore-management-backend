package com.devi.bookstore.service.implementations;

import com.devi.bookstore.dao.interfaces.AuthorsDAO;
import com.devi.bookstore.dto.AddAuthorDTO;
import com.devi.bookstore.model.Authors;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.repository.BookRepository;
import com.devi.bookstore.service.interfaces.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Autowired
    private AuthorsDAO authorsdao;

    @Autowired
    private BookRepository booksRepository;

    @Transactional
    @Override
    public List<Authors> getAllAuthors() {
        return authorsdao.getAllAuthors();
    }

    @Override
    @Cacheable(value = "authors", key = "#id")
    public Authors get(int id) {
        return authorsdao.get(id);
    }

    @Transactional
    @Override
    @CachePut(value = "authors", key = "#result.id")
    public Authors saveAuthor(AddAuthorDTO addAuthorDTO) {
        return authorsdao.saveAuthor(addAuthorDTO);
    }

    @Transactional
    @Override
    public List<Books> getBooksByAuthorId(int authorId){
        return booksRepository.findByAuthorId(authorId);
    }

    @Override
    @Cacheable(value = "authors", key = "#firstname + '-' + #lastname")
    public Authors getAuthorsByFirstNameAndLastName(String firstname, String lastname) {
        return authorsdao.getAuthorsByFirstNameAndLastName(firstname, lastname);
    }
}