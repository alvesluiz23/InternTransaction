package com.LuluPay.InternTransaction.Repository;

import com.LuluPay.InternTransaction.Entity.Balance;
import com.LuluPay.InternTransaction.Entity.Transaction;

import java.util.stream.Stream;

public interface BalanceRepository {
    void save(Balance balance);
    Balance findByUserId(String userId);
}
