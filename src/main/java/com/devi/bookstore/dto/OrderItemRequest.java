package com.devi.bookstore.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    @NotNull(message = "editionId is mandatory")
    private Integer editionId;

    @NotNull(message = "unit price is mandatory")
    private Double price;

    @NotNull(message = "quantity should be mentioned")
    private Integer quantity;

    @NotNull(message = "total can't be empty")
    private Double value;
}
