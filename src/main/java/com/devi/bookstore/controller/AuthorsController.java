package com.devi.bookstore.controller;

import com.devi.bookstore.dto.AddAuthorDTO;
import com.devi.bookstore.model.Authors;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.service.interfaces.AuthorsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
@CrossOrigin(origins = "http://localhost:5173/")
//@Validated
public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    @GetMapping("/authors")
    public List<Authors> getAllAuthors() {
        return authorsService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Authors get(@PathVariable int id){
        return authorsService.get(id);
    }

    @PostMapping("/authors")
    public ResponseEntity<Authors> save(@Valid @RequestBody
                                        AddAuthorDTO addAuthorDTO) {
        Authors savedAuthor = authorsService.saveAuthor(addAuthorDTO);
        return ResponseEntity.ok(savedAuthor);
    }

    @GetMapping("/authors/{authorId}/books")
    public List<Books> getBooksByAuthorId(@PathVariable int authorId) {
        return authorsService.getBooksByAuthorId(authorId);
    }
}