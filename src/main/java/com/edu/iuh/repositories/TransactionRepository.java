package com.edu.iuh.repositories;

import com.edu.iuh.entities.Transaction_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction_, String> {
}