package com.devi.bookstore.dao.implementations;

import com.devi.bookstore.dao.interfaces.AuthorsDAO;
import com.devi.bookstore.dto.AddAuthorDTO;
import com.devi.bookstore.model.Authors;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.repository.AuthorRepository;
import com.devi.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorsDAOImpl implements AuthorsDAO {

    @Autowired
    AuthorRepository authorsRepository;

    @Autowired
    BookRepository booksRepository;

    @Override
    public List<Authors> getAllAuthors() {
        return authorsRepository.findAll();
    }

    @Override
    public Authors get(int id) {
        Optional<Authors> author = authorsRepository.findById(id);
        return author.orElse(null);
    }

    @Override
    public Authors saveAuthor(AddAuthorDTO addAuthorDTO) {
        Authors author = new Authors();
        author.setFirstname(addAuthorDTO.getFirstName());
        author.setLastname(addAuthorDTO.getLastName());
        return authorsRepository.save(author);
    }

    @Override
    public List<Books> getBooksByAuthorId(int authorId) {
        return booksRepository.findByAuthorId(authorId);
    }

    @Override
    public Authors getAuthorsByFirstNameAndLastName(String firstname, String lastname) {
        Optional<Authors> author = authorsRepository.findByFirstnameAndLastname(firstname, lastname);
        return author.orElse(null);
    }
}
