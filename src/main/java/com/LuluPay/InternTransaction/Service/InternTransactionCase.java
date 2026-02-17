package com.LuluPay.InternTransaction.Service;

import com.LuluPay.InternTransaction.Entity.Transaction;
import com.LuluPay.InternTransaction.Repository.BalanceRepository;
import com.LuluPay.InternTransaction.Repository.TransactionRepository;
import com.LuluPay.InternTransaction.Entity.Balance;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class InternTransactionCase {
    private TransactionRepository transactionRepository;
    private BalanceRepository balanceRepository;


    public InternTransactionCase(TransactionRepository transactionRepository, BalanceRepository balanceRepository){
        this.transactionRepository = transactionRepository;
        this.balanceRepository = balanceRepository;
    }

    public Stream<Transaction> transactionListById(String sendId){
        return transactionRepository.findByUserId(sendId);
    }

    public boolean createTransaction(String transactionId, String senderId, String receiverId, Integer transactionType, Integer value, Integer status, LocalDateTime createdAT, LocalDateTime updatedAt){
        Balance balanceSender = balanceRepository.findByUserId(senderId);

        if(balanceSender.getBalance() < value){
            return false;
        }
        Balance balanceReceiver = balanceRepository.findByUserId(receiverId);
        balanceSender.witdraw(value);
        balanceRepository.save(balanceSender);
        balanceReceiver.deposit(value);
        balanceRepository.save(balanceReceiver);


        Transaction transaction = new Transaction(transactionId,senderId,receiverId,transactionType,value,status, LocalDateTime.now(), LocalDateTime.now());
        transactionRepository.save(transaction);
        return true;
    }

}
