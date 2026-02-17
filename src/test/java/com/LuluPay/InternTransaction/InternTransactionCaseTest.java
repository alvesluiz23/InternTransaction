package com.LuluPay.InternTransaction;

import com.LuluPay.InternTransaction.Entity.Balance;
import com.LuluPay.InternTransaction.Entity.Transaction;
import com.LuluPay.InternTransaction.Mock.BalanceRepositoryMock;
import com.LuluPay.InternTransaction.Mock.MockTransactionRepository;
import com.LuluPay.InternTransaction.Repository.BalanceRepository;
import com.LuluPay.InternTransaction.Repository.TransactionRepository;
import com.LuluPay.InternTransaction.Service.InternTransactionCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InternTransactionCaseTest {


    InternTransactionCase internTransactionCase;


    @Test
    @DisplayName("Testing getting transaction by id")
    void getTransactionsByIdTest() {
        MockTransactionRepository mockTransactionRepository = new MockTransactionRepository();
        BalanceRepository balanceRepository = new BalanceRepositoryMock();
        internTransactionCase = new InternTransactionCase(mockTransactionRepository, balanceRepository);
        Stream<Transaction> transactionById = internTransactionCase.transactionListById(2);

        long count = transactionById.count();
        assertEquals(1, count);
    }

    @Test
    @DisplayName("Testing creating trasanction without enough balance")
    void creatingTransactionWithoutBalance() {
        MockTransactionRepository mockTransactionRepository = new MockTransactionRepository();
        BalanceRepository balanceRepository = new BalanceRepositoryMock();
        internTransactionCase = new InternTransactionCase(mockTransactionRepository, balanceRepository);
        var result = internTransactionCase.createTransaction("11", "10", "10", 0, 15, 0, LocalDateTime.now(),LocalDateTime.now());

        assertEquals(false, result);
    }

    @Test
    @DisplayName("creating transaction with enough balance")
    void creatingTransactionWithBalance() {
        Balance sender = new Balance("user1", 1000);
        Balance receiver = new Balance("user2", 500);

        BalanceRepository balanceRepository = mock(BalanceRepository.class);
        TransactionRepository transactionRepository = mock(TransactionRepository.class);

        when(balanceRepository.findByUserId("10")).thenReturn(sender);
        when(balanceRepository.findByUserId("11")).thenReturn(receiver);

        internTransactionCase = new InternTransactionCase(transactionRepository, balanceRepository);
        var result = internTransactionCase.createTransaction("11", "10", "11", 0, 10, 0, LocalDateTime.now(),LocalDateTime.now());


        assertEquals(receiver.getBalance(),510);
        assertEquals(sender.getBalance(),990);
        assertEquals(true, result);
    }

}
