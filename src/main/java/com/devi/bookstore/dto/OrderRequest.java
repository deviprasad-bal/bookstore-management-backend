package com.devi.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    @NotNull(message = "total is mandatory field")
    private Double total;

    @NotBlank(message = "order status is mandatory")
    private String status;

    @NotEmpty(message = "OrderItems' List can't be empty")
    private List<OrderItemRequest> items;
}
