package com.devi.bookstore.dao.implementations;

import com.devi.bookstore.dao.interfaces.EditionsDAO;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.model.Editions;
import com.devi.bookstore.repository.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EditionsDAOImpl implements EditionsDAO {

    @Autowired
    EditionRepository editionsRepository;

    @Override
    public List<Editions> getEditionsByBookId(int bookId) {
        return editionsRepository.findByBookId(bookId);
    }

    @Override
    public Optional<Editions> getEditionsByBookAndEditionNo(Books book, int editionNo) {
        return editionsRepository.findByBookAndEditionNo(book, editionNo);
    }
}
