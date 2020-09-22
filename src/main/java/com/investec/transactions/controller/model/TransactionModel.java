package com.investec.transactions.controller.model;

public class TransactionRESTModel {

    private String clientName;
    private double transactionAmount;

    public String getFullName() {
        return clientName;
    }

    public void setFullName(String clientName) {
        this.clientName = clientName;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
