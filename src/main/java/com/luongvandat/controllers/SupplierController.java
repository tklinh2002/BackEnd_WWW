package com.luongvandat.controllers;

import com.luongvandat.entities.Supplier;
import com.luongvandat.services.SupplierServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/suppliers")
public class SupplierController {
    private SupplierServices supplierServices;

    public SupplierController(SupplierServices supplierServices) {
        this.supplierServices = supplierServices;
    }
    @PostMapping("/addSupplier")
    ResponseEntity<String> addSupplier(@RequestBody Supplier a){
        if(supplierServices.findSupplierBySupplierNameIgnoreCase(a.getSupplierName())!=null){
            return ResponseEntity.ok("Supplier exist!!!");
        }
        supplierServices.add(a);
        return ResponseEntity.ok("add Supplier successful");
    }
    @PutMapping("/updateSupplier")
    ResponseEntity<String> updateSupplier(@RequestBody Supplier a){
        Supplier supplier = supplierServices.findOneById(a.getSupplierId());
        supplier.setSupplierName(a.getSupplierName());
        supplierServices.update(supplier);
        return ResponseEntity.ok("update Category successful");
    }
    @GetMapping("/deleteSupplier")
    ResponseEntity<String> deleteSupplier(@RequestParam String supplierName){
        Supplier supplier = supplierServices.findSupplierBySupplierNameIgnoreCase(supplierName);
        supplierServices.deleteById(supplier.getSupplierId());
        return ResponseEntity.ok("delete Category successful");
    }

}
