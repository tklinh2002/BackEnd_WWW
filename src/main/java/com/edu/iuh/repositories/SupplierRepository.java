package com.edu.iuh.repositories;

import com.edu.iuh.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
//@CrossOrigin(origins = "http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")

public interface SupplierRepository extends JpaRepository<Supplier, String> {
    Supplier findBySupplierName(String name);
    List<Supplier> findSuppliersBy();
    @Query(value = "SELECT * FROM supplier ORDER BY supplier_id ASC OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
    List<Supplier> find10Suppliers(int offset);
    @Query(value = "SELECT * FROM supplier where supplier_name like '%'+?1+'%' ORDER BY supplier_id ASC OFFSET ?2 ROWS FETCH NEXT 10 ROWS ONLY ",nativeQuery = true)
    List<Supplier> search10SupplierByName(String supplierName, int offset);

    int countSuppliersBy();
    Supplier findSupplierBySupplierNameIgnoreCase(String supplierName);
}