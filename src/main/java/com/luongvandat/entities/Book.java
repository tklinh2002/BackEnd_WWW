package com.luongvandat.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookId;
    private double bookPrice;
    private String bookTitle;
    private int bookDiscount;
    private String bookDescription;
    private String bookSize;
    private String bookTranslator;
    private double bookWeight;
    private String bookType;
    private int bookInventory;
    private String bookLanguage;
    private String bookStatus;
    private String bookSlug;
    private String bookImage;
    private Date bookCreatedDate;
    private Date bookUpdatedDate;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Category category;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Publisher publisher;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Author author;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Supplier supplier;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetails;
}