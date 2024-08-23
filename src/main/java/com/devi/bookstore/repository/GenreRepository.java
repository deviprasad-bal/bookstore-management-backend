package com.devi.bookstore.repository;

import com.devi.bookstore.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genres,Integer> {
    Optional<Genres> findByName(String name);
}