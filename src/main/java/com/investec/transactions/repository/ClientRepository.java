package com.investec.transactions.repository;

import com.investec.transactions.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByIdNumber(String idNumber);

    Client findByMobileNumber(String mobileNumber);

    Client findByFirstName(String value);

    Client findByFirstNameAndIdNumberAndMobileNumber(String firstName, String IdNumber, String mobileNumber);

}
