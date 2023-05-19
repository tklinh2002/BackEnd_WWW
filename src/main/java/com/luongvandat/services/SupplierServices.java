package com.luongvandat.services;

import com.luongvandat.entities.Supplier;

import java.util.List;

public interface SupplierServices {
    Supplier findOneById(String id);

    Supplier add(Supplier supplier);

    Supplier deleteById(String id);

    Supplier update(Supplier supplier);

    Supplier findBySupplierName(String name);
    List<Supplier> findSuppliersBy();

    List<Supplier> find10Suppliers(int offset);

    List<Supplier> search10SupplierByName(String supplierName, int offset);

    int countSuppliersBy();
    Supplier findSupplierBySupplierNameIgnoreCase(String supplierName);
}