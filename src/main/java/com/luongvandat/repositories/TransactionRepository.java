package com.luongvandat.repositories;

import com.luongvandat.entities.Transaction_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction_, String> {
}