package com.LuluPay.InternTransaction.Mock;

import com.LuluPay.InternTransaction.Entity.Balance;
import com.LuluPay.InternTransaction.Entity.Transaction;
import com.LuluPay.InternTransaction.Repository.BalanceRepository;

public class BalanceRepositoryMock implements BalanceRepository {
    @Override
    public void save(Balance balance) {
    }

    @Override
    public Balance findByUserId(String userId) {
        return new Balance("10", 10);
    }
}
