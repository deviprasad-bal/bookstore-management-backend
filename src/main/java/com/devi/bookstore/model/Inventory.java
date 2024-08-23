package com.devi.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@ToString
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "edition_id", referencedColumnName = "id")
    private Editions edition;

    @Column(name = "sold_stocks", nullable = false)
    private int soldStocks;

    @Column(name = "total_stocks", nullable = false)
    private int totalStocks;
}