package com.devi.bookstore.controller;

import com.devi.bookstore.dto.AddBookDTO;
import com.devi.bookstore.dto.AddBookDetailsDTO;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.service.interfaces.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devi.bookstore.service.interfaces.BooksService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookstore")
@CrossOrigin(origins = "http://localhost:5173/")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/books")
    public List<Books> get(){
        return booksService.get();
    }

    @GetMapping("/books/{id}")
    public Books get(@PathVariable int id){
        return booksService.get(id);
    }

    @PostMapping("/books")
    public ResponseEntity<Books> save(@Valid @RequestBody
                                      AddBookDTO addBookDTO) {
        Books savedBook = booksService.save(addBookDTO);
        return ResponseEntity.ok(savedBook);
    }

    @DeleteMapping("books/{id}")
    public String delete(@PathVariable int id){
        booksService.delete(id);
        return "Book has been deleted from Inventory";
    }

    @GetMapping("/books/search")
    public Optional<Books> searchBooks(@RequestParam String query) {
        return booksService.searchBooks(query);
    }

    @PostMapping("/books/add")
    public Books saveBookWithDetails(@Valid @RequestBody AddBookDetailsDTO addBookDetailsDTO) {
        return booksService.saveBookWithDetails(addBookDetailsDTO);
    }

}