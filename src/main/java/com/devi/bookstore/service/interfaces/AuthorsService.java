package com.devi.bookstore.service.interfaces;

import com.devi.bookstore.dto.AddAuthorDTO;
import com.devi.bookstore.model.Authors;
import com.devi.bookstore.model.Books;

import java.util.List;

public interface AuthorsService {
    List<Authors> getAllAuthors();

    Authors get(int id); //for Author's name usage in BooksByAuthor

    Authors saveAuthor(AddAuthorDTO addAuthorDTO);

    List<Books> getBooksByAuthorId(int authorId);

    Authors getAuthorsByFirstNameAndLastName(String firstname, String lastname);
}
