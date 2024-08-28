package com.devi.bookstore.service.implementations;

import com.devi.bookstore.dao.interfaces.EditionsDAO;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.model.Editions;
import com.devi.bookstore.service.interfaces.EditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EditionsServiceImpl implements EditionsService {

    @Autowired
    private EditionsDAO editionsDAO;

    @Transactional
    @Override
    public List<Editions> getEditionsByBookId(int bookId) {
        return editionsDAO.getEditionsByBookId(bookId);
    }

    @Transactional
    @Override
    @Cacheable(value = "editions", key = "#book.id + '-' + #editionNo")
    public Optional<Editions> getEditionsByBookAndEditionNo(Books book, int editionNo) {
        return editionsDAO.getEditionsByBookAndEditionNo(book, editionNo);
    }
}