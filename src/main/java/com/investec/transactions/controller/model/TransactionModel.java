package com.investec.transactions.controller.model;

import com.investec.transactions.domain.Transaction;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionModel {


    private long transactionId;
    @NotNull(message = "Client name must not be null")
    @NotBlank(message = "Client name must not be empty")
     private String clientName;
    @NotNull(message = "Transaction amount must not be null")
    @NotBlank(message = "Transaction amount must not be empty")
    private double transactionAmount;

    public TransactionModel() {
    }

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

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
