package com.luongvandat.services.impl;

import com.luongvandat.entities.Transaction_;
import com.luongvandat.repositories.TransactionRepository;
import com.luongvandat.services.TransactionServices;
import org.springframework.stereotype.Service;

@Service
public class TransactionServicesImpl implements TransactionServices {
    private final TransactionRepository transactionRepository;

    public TransactionServicesImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction_ findOneById(String id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaction_ add(Transaction_ transaction_) {
        return transactionRepository.save(transaction_);
    }

    @Override
    public Transaction_ deleteById(String id) {
        Transaction_ transaction = findOneById(id);
        transactionRepository.deleteById(id);
        return transaction;
    }

    @Override
    public Transaction_ update(Transaction_ transaction_) {
        return transactionRepository.save(transaction_);
    }
}