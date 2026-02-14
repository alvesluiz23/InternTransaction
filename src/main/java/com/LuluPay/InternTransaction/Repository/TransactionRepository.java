package com.LuluPay.InternTransaction.Repository;

import com.LuluPay.InternTransaction.Entity.Transaction;

import java.util.List;
import java.util.stream.Stream;

public interface TransactionRepository {
    void save(Transaction transaction);
    Stream<Transaction> findByUserId(String userId);
}