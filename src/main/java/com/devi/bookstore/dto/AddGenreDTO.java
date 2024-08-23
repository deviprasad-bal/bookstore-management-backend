package com.devi.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddGenreDTO {
    @NotBlank(message = "Genre is required")
    private String name;
}