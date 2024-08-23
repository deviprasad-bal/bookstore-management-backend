package com.devi.bookstore.controller;

import com.devi.bookstore.model.Editions;
import com.devi.bookstore.service.interfaces.EditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
@CrossOrigin(origins = "http://localhost:5173/")
public class EditionsController {

    @Autowired
    private EditionsService editionsService;

    @GetMapping("books/{bookId}/editions")
    public List<Editions> getInventory(@PathVariable int bookId){
        return editionsService.getEditionsByBookId(bookId);
    }
}
