package com.edu.iuh.services;

import com.edu.iuh.entities.ShippingAddress;

public interface ShippingAddressServices {
    ShippingAddress findOneById(String id);

    ShippingAddress add(ShippingAddress shippingAddress);

    ShippingAddress deleteById(String id);

    ShippingAddress update(ShippingAddress shippingAddress);
}