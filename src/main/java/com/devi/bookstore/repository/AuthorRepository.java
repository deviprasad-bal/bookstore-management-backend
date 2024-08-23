package com.devi.bookstore.repository;

import com.devi.bookstore.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Authors,Integer> {
    Optional<Authors> findByFirstnameAndLastname(String firstname, String lastname);
}