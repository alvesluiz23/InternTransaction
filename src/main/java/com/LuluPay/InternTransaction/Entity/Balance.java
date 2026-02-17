package com.LuluPay.InternTransaction.Entity;

public class Balance {
    private String userId;
    private Integer balance;

    public Balance(String userId, Integer balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void witdraw(Integer balance) {
        this.balance -= balance;
    }

    public void deposit(Integer balance) {
        this.balance += balance;
    }
}
