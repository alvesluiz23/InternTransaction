package com.LuluPay.InternTransaction.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    private String transactionId;
    private String senderId;
    private String ReceiverId;
    private Integer transactionType;
    private Integer value;
    private Integer status;
    private LocalDateTime createdAT;
    private LocalDateTime updatedAt;

    public Transaction(String transactionId, String senderId, String receiverId, Integer transactionType, Integer value, Integer status, LocalDateTime createdAT, LocalDateTime updatedAt) {
        this.transactionId = transactionId;
        this.senderId = senderId;
        this.ReceiverId = receiverId;
        this.transactionType = transactionType;
        this.value = value;
        this.status = status;
        this.createdAT = createdAT;
        this.updatedAt = updatedAt;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return ReceiverId;
    }

    public void setReceiverId(String receiverId) {
        ReceiverId = receiverId;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
