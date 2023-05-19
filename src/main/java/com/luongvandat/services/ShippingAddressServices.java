package com.luongvandat.services;

import com.luongvandat.entities.ShippingAddress;

public interface ShippingAddressServices {
    ShippingAddress findOneById(String id);

    ShippingAddress add(ShippingAddress shippingAddress);

    ShippingAddress deleteById(String id);

    ShippingAddress update(ShippingAddress shippingAddress);
}