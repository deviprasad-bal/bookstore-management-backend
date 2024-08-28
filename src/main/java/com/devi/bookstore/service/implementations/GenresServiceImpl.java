package com.devi.bookstore.service.implementations;

import com.devi.bookstore.dao.interfaces.GenresDAO;
import com.devi.bookstore.dto.AddGenreDTO;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.model.Genres;
import com.devi.bookstore.repository.BookRepository;
import com.devi.bookstore.service.interfaces.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenresServiceImpl implements GenresService {

    @Autowired
    private GenresDAO genresdao;

    @Autowired
    private BookRepository booksRepository;

    @Transactional
    @Override
    public List<Genres> getAllGenres() {
        return genresdao.getAllGenres();
    }

    @Transactional
    @Override
    @Cacheable(value = "genres", key = "#id")
    public Genres get(int id) {
        return genresdao.get(id);
    }

    @Transactional
    @Override
    @CachePut(value = "genres", key = "#result.id")
    public Genres saveGenre(AddGenreDTO addGenreDTO) {
        return genresdao.saveGenre(addGenreDTO);
    }

    @Transactional
    @Override
    public List<Books> getBooksByGenreId(int genreId) {
        return booksRepository.findByGenreId(genreId);
    }

    @Transactional
    @Override
    @Cacheable(value = "genres", key = "#name")
    public Genres getGenresByName(String name) {
        return genresdao.getGenresByName(name);
    }
}