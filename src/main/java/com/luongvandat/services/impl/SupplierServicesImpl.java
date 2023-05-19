package com.luongvandat.services.impl;

import com.luongvandat.entities.Supplier;
import com.luongvandat.repositories.SupplierRepository;
import com.luongvandat.services.SupplierServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServicesImpl implements SupplierServices {
    private final SupplierRepository supplierRepository;

    public SupplierServicesImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier findOneById(String id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Supplier add(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier deleteById(String id) {
        Supplier supplier = findOneById(id);
        supplierRepository.deleteById(id);
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier findBySupplierName(String name) {
        return supplierRepository.findBySupplierName(name);
    }

    @Override
    public List<Supplier> findSuppliersBy() {
        return supplierRepository.findSuppliersBy();
    }

    @Override
    public List<Supplier> find10Suppliers(int offset) {
        return supplierRepository.find10Suppliers(offset);
    }

    @Override
    public List<Supplier> search10SupplierByName(String supplierName, int offset) {
        return supplierRepository.search10SupplierByName(supplierName, offset);
    }

    @Override
    public int countSuppliersBy() {
        return supplierRepository.countSuppliersBy();
    }

    @Override
    public Supplier findSupplierBySupplierNameIgnoreCase(String supplierName) {
        return supplierRepository.findSupplierBySupplierNameIgnoreCase(supplierName);
    }
}