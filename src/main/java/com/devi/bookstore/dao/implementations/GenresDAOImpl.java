package com.devi.bookstore.dao.implementations;

import com.devi.bookstore.dao.interfaces.GenresDAO;
import com.devi.bookstore.dto.AddGenreDTO;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.model.Genres;
import com.devi.bookstore.repository.BookRepository;
import com.devi.bookstore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GenresDAOImpl implements GenresDAO {

    @Autowired
    GenreRepository genresRepository;

    @Autowired
    BookRepository booksRepository;

    @Override
    public List<Genres> getAllGenres() {
        return genresRepository.findAll();
    }

    @Override
    public Genres get(int id) {
        Optional<Genres> genre = genresRepository.findById(id);
        return genre.orElse(null);
    }

    @Override
    public Genres saveGenre(AddGenreDTO addGenreDTO) {
        Genres genre = new Genres();
        genre.setName(addGenreDTO.getName());
        return genresRepository.save(genre);
    }

    @Override
    public List<Books> getBooksByGenreId(int genreId) {
        return booksRepository.findByGenreId(genreId);
    }

    @Override
    public Genres getGenresByName(String name) {
        Optional<Genres> genre = genresRepository.findByName(name);
        return genre.orElse(null);
    }

}
