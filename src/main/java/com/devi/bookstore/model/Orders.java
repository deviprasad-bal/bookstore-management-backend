package com.devi.bookstore.model;

import com.devi.bookstore.utils.DateTimeUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "order_status", nullable = false)
    private String orderStatus;
}
