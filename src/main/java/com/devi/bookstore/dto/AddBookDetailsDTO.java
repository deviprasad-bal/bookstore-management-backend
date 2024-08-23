package com.devi.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AddBookDetailsDTO {
    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "First name is mandatory")
    private String authorFirstName;

    @NotBlank(message = "Last name is mandatory")
    private String authorLastName;

    @NotBlank(message = "Genre is mandatory")
    private String genre;

    @NotNull(message = "Edition is mandatory")
    private Integer editionNo;

    @NotNull(message = "Date is mandatory")
    private Date publishedOn;

    @NotNull(message = "Price is mandatory")
    private Integer price;

    @NotNull(message = "Stocks is mandatory")
    private Integer stocks;
}
