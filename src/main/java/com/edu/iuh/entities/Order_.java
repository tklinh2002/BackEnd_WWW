package com.edu.iuh.entities;

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
public class Order_ {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;
    private Date orderDate;
    private String shippingAddress;
    private String orderNote;
    private String orderDiscount;
    private String orderStatus;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User_ user_;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "order_")
    private Set<Transaction_> transactions;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "order_")
    private Set<OrderDetail> orderDetails;
}