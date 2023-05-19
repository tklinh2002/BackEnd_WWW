package com.edu.iuh.services.impl;

import com.edu.iuh.repositories.ShippingAddressRepository;
import com.edu.iuh.entities.ShippingAddress;
import com.edu.iuh.services.ShippingAddressServices;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressServicesImpl implements ShippingAddressServices {
    private final ShippingAddressRepository shippingAddressRepository;

    public ShippingAddressServicesImpl(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
    }

    @Override
    public ShippingAddress findOneById(String id) {
        return shippingAddressRepository.findById(id).orElse(null);
    }

    @Override
    public ShippingAddress add(ShippingAddress shippingAddress) {
        return shippingAddressRepository.save(shippingAddress);
    }

    @Override
    public ShippingAddress deleteById(String id) {
        ShippingAddress shippingAddress = findOneById(id);
        shippingAddressRepository.deleteById(id);
        return shippingAddress;
    }

    @Override
    public ShippingAddress update(ShippingAddress shippingAddress) {
        return shippingAddressRepository.save(shippingAddress);
    }
}