package com.edu.iuh.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.REMOVE)
    @MapsId("orderId")
    private Order_ order_;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.REMOVE)
    @MapsId("bookId")
    private Book book;
    private int quantity;
    private double price;
}