package com.devi.bookstore.repository;

import com.devi.bookstore.model.Authors;
import com.devi.bookstore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    List<Books> findByAuthorId(int authorId); //lists books by specific authorId
    List<Books> findByGenreId(int genreId); //lists books by specific genreId
    Optional<Books> findByTitleContainingIgnoreCase(String title); //lists books by specific String(author, title, genre)
}
