package com.LuluPay.InternTransaction;

import com.LuluPay.InternTransaction.Entity.Balance;
import com.LuluPay.InternTransaction.Entity.Transaction;
import com.LuluPay.InternTransaction.Repository.BalanceRepository;
import com.LuluPay.InternTransaction.Repository.TransactionRepository;
import com.LuluPay.InternTransaction.Service.InternTransactionCase;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InternTransactionCaseTest {


    InternTransactionCase internTransactionCase;
    static BalanceRepository balanceRepository;
    static TransactionRepository transactionRepository;

    @BeforeAll
    static void prepareTest(){
         balanceRepository = mock(BalanceRepository.class);
         transactionRepository = mock(TransactionRepository.class);
    }

    @Test
    @DisplayName("Testing getting transaction by id")
    void getTransactionsByIdTest() {
        Stream<Transaction> transactions =  Stream.of(new Transaction("10","20","1",1, 0, 0,LocalDateTime.now(), LocalDateTime.now()));
        when(transactionRepository.findByUserId("2")).thenReturn(transactions);

        internTransactionCase = new InternTransactionCase(transactionRepository, balanceRepository);
        Stream<Transaction> transactionById = internTransactionCase.transactionListById("2");

        long count = transactionById.count();
        assertEquals(1, count);
    }

    @Test
    @DisplayName("Testing creating trasanction without enough balance")
    void creatingTransactionWithoutBalance() {
        Balance sender = new Balance("10", 6);
        Balance receiver = new Balance("11", 500);
        
        when(balanceRepository.findByUserId("10")).thenReturn(sender);
        when(balanceRepository.findByUserId("11")).thenReturn(receiver);

        internTransactionCase = new InternTransactionCase(transactionRepository, balanceRepository);
        var result = internTransactionCase.createTransaction("11", "10", "11", 0, 15, 0, LocalDateTime.now(),LocalDateTime.now());

        assertEquals(false, result);
    }

    @Test
    @DisplayName("creating transaction with enough balance")
    void creatingTransactionWithBalance() {
        Balance sender = new Balance("user1", 1000);
        Balance receiver = new Balance("user2", 500);


        when(balanceRepository.findByUserId("10")).thenReturn(sender);
        when(balanceRepository.findByUserId("11")).thenReturn(receiver);

        internTransactionCase = new InternTransactionCase(transactionRepository, balanceRepository);
        var result = internTransactionCase.createTransaction("11", "10", "11", 0, 10, 0, LocalDateTime.now(),LocalDateTime.now());


        assertEquals(receiver.getBalance(),510);
        assertEquals(sender.getBalance(),990);
        assertEquals(true, result);
    }

}
