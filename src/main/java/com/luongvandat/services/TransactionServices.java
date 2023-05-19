package com.luongvandat.services;

import com.luongvandat.entities.Transaction_;

public interface TransactionServices {
    Transaction_ findOneById(String id);

    Transaction_ add(Transaction_ transaction_);

    Transaction_ deleteById(String id);

    Transaction_ update(Transaction_ transaction_);
}