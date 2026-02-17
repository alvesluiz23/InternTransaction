package com.LuluPay.InternTransaction.Mock;

import com.LuluPay.InternTransaction.Entity.Transaction;
import com.LuluPay.InternTransaction.Repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class MockTransactionRepository implements TransactionRepository {

    @Override
    public void save(Transaction transaction) {

    }

    @Override
    public Stream<Transaction> findByUserId(Integer userId) {
        Stream<Transaction> transactions =  Stream.of(new Transaction("10","20","1",1, 0, 0,LocalDateTime.now(), LocalDateTime.now()));
        return transactions;
    }



}
