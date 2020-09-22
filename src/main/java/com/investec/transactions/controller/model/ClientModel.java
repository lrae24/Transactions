package com.investec.transactions.controller.model;


import com.investec.transactions.domain.Client;

import java.util.List;

public class ClientModel {
    private long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String mobileNumber;
    private String idNumber;
    private String physicalAddress;

    private List<TransactionModel> transaction;

    public ClientModel(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.fullName = client.getFullName();
        this.mobileNumber = client.getMobileNumber();
        this.idNumber = client.getIdNumber();
        this.physicalAddress = client.getPhysicalAddress();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<TransactionModel> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<TransactionModel> transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                '}';
    }
}
