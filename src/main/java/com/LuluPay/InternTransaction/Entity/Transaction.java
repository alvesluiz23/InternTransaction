package com.LuluPay.InternTransaction.Entity;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private String senderId;
    private String ReceiverId;
    private Integer transactionType;
    private Integer value;
    private String status;
    private Date createdAT;
    private Date updatedAt;

    public Transaction(String senderId, String receiverId, Integer transactionType, Integer value) {
        this.senderId = senderId;
        ReceiverId = receiverId;
        this.transactionType = transactionType;
        this.value = value;
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
