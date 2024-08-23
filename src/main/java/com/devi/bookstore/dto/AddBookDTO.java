package com.devi.bookstore.dto;

import com.devi.bookstore.model.Authors;
import com.devi.bookstore.model.Genres;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookDTO {
    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotNull(message = "Author is mandatory")
    private Authors author;

    @NotNull(message = "Genre is mandatory")
    private Genres genre;
}
