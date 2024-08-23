package com.devi.bookstore.controller;

import com.devi.bookstore.dto.AddGenreDTO;
import com.devi.bookstore.model.Genres;
import com.devi.bookstore.model.Books;
import com.devi.bookstore.service.interfaces.GenresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
@CrossOrigin(origins = "http://localhost:5173/")
public class GenresController {

    @Autowired
    private GenresService genresService;

    @GetMapping("/genres")
    public List<Genres> getAllGenres() {
        return genresService.getAllGenres();
    }

    @GetMapping("/genres/{id}")
    public Genres get(@PathVariable int id){
        return genresService.get(id);
    }

    @PostMapping("/genres")
    public ResponseEntity<Genres> save(@Valid @RequestBody
                                       AddGenreDTO addGenreDTO) {
        Genres savedGenre = genresService.saveGenre(addGenreDTO);
        return ResponseEntity.ok(savedGenre);
    }

    @GetMapping("/genres/{genreId}/books")
    public List<Books> getBooksByGenreId(@PathVariable int genreId) {
        return genresService.getBooksByGenreId(genreId);
    }
}
