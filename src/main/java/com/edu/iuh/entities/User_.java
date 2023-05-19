package com.edu.iuh.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class User_ {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String userName;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userPhoneNumber;
    private String userEmail;
    private Date userCreatedDate;
    private Date userUpdatedDate;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Role role;
    @OneToMany(mappedBy = "user_")
    private Set<ShippingAddress> shippingAddresses;
    @OneToMany(mappedBy = "user_")
    private Set<Order_> orders;
    @OneToMany(mappedBy = "user_")
    private Set<Comment> comments;
}