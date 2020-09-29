package com.investec.transactions.domain;

import com.investec.transactions.controller.model.TransactionModel;

import javax.persistence.*;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String clientName;
    @Column
    private double transactionAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="clientId")
    private Client clientId;

    public Transaction() {
    }

    public Transaction(String clientName, double transactionAmount) {
        this.clientName = clientName;
        this.transactionAmount = transactionAmount;
    }

    public Transaction(TransactionModel trasnaction, Client client) {
        this.clientName = trasnaction.getClientName();
        this.transactionAmount = trasnaction.getTransactionAmount();
        this.clientId = client;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }
}
