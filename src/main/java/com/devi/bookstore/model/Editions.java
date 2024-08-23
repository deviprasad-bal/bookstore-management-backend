package com.devi.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "editions")
@Getter
@Setter
@ToString
public class Editions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books book;

    @Column(name = "edition_no", nullable = false)
    private int editionNo;

    @Column(name = "published_on", nullable = false)
    private Date publishedOn;

    @Column(name = "price", nullable = false)
    private double price;

    @OneToOne(mappedBy = "edition")
    @JsonManagedReference
    private Inventory inventory;
}
