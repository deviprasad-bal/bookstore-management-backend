package com.devi.bookstore.dao.implementations;

import com.devi.bookstore.dao.interfaces.BooksDAO;
import com.devi.bookstore.dto.AddBookDTO;
import com.devi.bookstore.dto.AddBookDetailsDTO;
import com.devi.bookstore.model.*;
import com.devi.bookstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class BooksDAOImpl implements BooksDAO {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    EditionRepository editionRepository;

    @Autowired
    InventoryRepository inventoryRepository;


    @Override
    public List<Books> get() {
        return bookRepository.findAll();
    }

    @Override
    public Books get(int id) {
        Optional<Books> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Books save(AddBookDTO addBookDTO) {
        Books book = new Books();
        book.setTitle(addBookDTO.getTitle());
        book.setAuthor(addBookDTO.getAuthor());
        book.setGenre(addBookDTO.getGenre());
        return bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Books> searchBooks(String query) {
        return bookRepository.findByTitleContainingIgnoreCase(query);
    }

    @Override
    public Books saveBookWithDetails(AddBookDetailsDTO addBookDetailsDTO) {

//        if (addBookDetailsDTO.getPrice() == null) {
//            throw new IllegalArgumentException("Price cannot be null.");
//        } else if (addBookDetailsDTO.getStocks() == null) {
//            throw new IllegalArgumentException("Stocks cannot be null.");
//        }


        Authors author = authorRepository.findByFirstnameAndLastname(addBookDetailsDTO.getAuthorFirstName(), addBookDetailsDTO.getAuthorLastName())
                .orElseGet(() -> {
                    Authors newAuthor = new Authors();
                    newAuthor.setFirstname(addBookDetailsDTO.getAuthorFirstName());
                    newAuthor.setLastname(addBookDetailsDTO.getAuthorLastName());
                    return authorRepository.save(newAuthor);
                });

        Genres genre = genreRepository.findByName(addBookDetailsDTO.getGenre())
                .orElseGet(() -> {
                    Genres newGenre = new Genres();
                    newGenre.setName(addBookDetailsDTO.getGenre());
                    return genreRepository.save(newGenre);
                });

        Optional<Books> optionalBook = bookRepository.findByTitleContainingIgnoreCase(addBookDetailsDTO.getTitle());

        Books book;
        if(optionalBook.isPresent()) {
            book = optionalBook.get();
            Optional<Editions> optionalEdition = editionRepository.findByBookAndEditionNo(book, addBookDetailsDTO.getEditionNo());
            if (optionalEdition.isPresent()) {
                throw new IllegalArgumentException("This edition already exists for the book.");
            }
        } else {
            book = new Books();
            book.setTitle(addBookDetailsDTO.getTitle());
            book.setAuthor(author);
            book.setGenre(genre);
            bookRepository.save(book);
        }

        Editions edition = new Editions();
        edition.setBook(book);
        edition.setEditionNo(addBookDetailsDTO.getEditionNo());
        edition.setPublishedOn(addBookDetailsDTO.getPublishedOn());
        edition.setPrice(addBookDetailsDTO.getPrice());
        editionRepository.save(edition);

        Inventory inventory = inventoryRepository.findByEditionId(edition.getId())
                .orElseGet(() -> {
                    Inventory newInventory = new Inventory();
                    newInventory.setEdition(edition);
                    newInventory.setSoldStocks(0);
                    newInventory.setTotalStocks(0);
                    return newInventory;
                });

        inventory.setTotalStocks(inventory.getTotalStocks() + addBookDetailsDTO.getStocks());
        inventoryRepository.save(inventory);

        return book;
    }
}