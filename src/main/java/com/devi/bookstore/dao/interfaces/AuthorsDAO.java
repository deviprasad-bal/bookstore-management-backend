package com.devi.bookstore.dao.interfaces;

import com.devi.bookstore.dto.AddAuthorDTO;
import com.devi.bookstore.model.Authors;
import com.devi.bookstore.model.Books;

import java.util.List;

public interface AuthorsDAO {
    List<Authors> getAllAuthors();

    Authors get(int id);

    Authors saveAuthor(AddAuthorDTO addAuthorDTO);

    List<Books> getBooksByAuthorId(int authorId);

    Authors getAuthorsByFirstNameAndLastName(String firstname, String lastname);


}
