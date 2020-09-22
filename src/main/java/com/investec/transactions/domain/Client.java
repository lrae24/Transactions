package com.investec.transactions.domain;

import com.investec.transactions.controller.model.ClientModel;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String fullName;
    @Column
    private String mobileNumber;
    @Column
    private String idNumber;
    @Column
    private String physicalAddress;


    public Client(ClientModel client) {
        this.clientId = client.getId();
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
        return clientId;
    }

    public void setId(long clientId) {
        this.clientId = clientId;
    }
}
