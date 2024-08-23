package com.devi.bookstore.dao.interfaces;

import com.devi.bookstore.dto.AddGenreDTO;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.model.Genres;

import java.util.List;

public interface GenresDAO {
    List<Genres> getAllGenres();

    Genres get(int id);

    Genres saveGenre(AddGenreDTO addGenreDTO);

    List<Books> getBooksByGenreId(int genreId);

    Genres getGenresByName(String name);
}
