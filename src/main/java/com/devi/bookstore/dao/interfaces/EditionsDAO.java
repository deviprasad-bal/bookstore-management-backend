package com.devi.bookstore.dao.interfaces;

import com.devi.bookstore.model.Books;
import com.devi.bookstore.model.Editions;

import java.util.List;
import java.util.Optional;

public interface EditionsDAO {
    List<Editions> getEditionsByBookId(int bookId);
    Optional<Editions> getEditionsByBookAndEditionNo(Books book, int editionNo);
}
