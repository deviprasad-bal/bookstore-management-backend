package com.devi.bookstore.service.implementations;

import com.devi.bookstore.dao.interfaces.GenresDAO;
import com.devi.bookstore.dto.AddGenreDTO;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.model.Genres;
import com.devi.bookstore.repository.BookRepository;
import com.devi.bookstore.service.interfaces.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresServiceImpl implements GenresService {

    @Autowired
    private GenresDAO genresdao;

    @Autowired
    private BookRepository booksRepository;

    @Override
    public List<Genres> getAllGenres() {     //to show list of genres
        return genresdao.getAllGenres();
    }

    @Override
    public Genres get(int id) {
        return genresdao.get(id);
    }

    @Override
    public Genres saveGenre(AddGenreDTO addGenreDTO) {    //while adding booksWithDetails if new genre, add that
        return genresdao.saveGenre(addGenreDTO);
    }

    @Override
    public List<Books> getBooksByGenreId(int genreId) {   //to show books of a particular genre
        return booksRepository.findByGenreId(genreId);
    }

    @Override
    public Genres getGenresByName(String name) {
        return genresdao.getGenresByName(name);
    }
}
