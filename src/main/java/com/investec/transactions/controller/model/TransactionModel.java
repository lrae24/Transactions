package com.investec.transactions.controller.model;

import com.investec.transactions.domain.Transaction;

public class TransactionModel {


    private long transactionId;
    private String clientName;
    private double transactionAmount;

    public TransactionModel(Transaction dbTransaction) {
        this.transactionId = dbTransaction.getId();
        this.clientName = dbTransaction.getClientName();
        this.transactionAmount = dbTransaction.getTransactionAmount();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
}
