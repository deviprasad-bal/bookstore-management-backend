package com.devi.bookstore.repository;

import com.devi.bookstore.model.Books;
import com.devi.bookstore.model.Editions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditionRepository extends JpaRepository<Editions, Integer> {
    List<Editions> findByBookId(int bookId);
    Optional<Editions> findByBookAndEditionNo(Books book, int editionNo);
}
