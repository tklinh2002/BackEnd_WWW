package com.luongvandat.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String shippingAddressId;
    private String shippingAddressFullNameOfReceiver;
    private String shippingAddressPhoneNumber;
    private String shippingAddressStreetAndHouseNumber;
    private String shippingAddressDistrict;
    private String shippingAddressWard;
    private String shippingAddressCity;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private User_ user_;
}