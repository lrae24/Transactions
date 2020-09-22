package com.investec.transactions.repository;

import com.investec.transactions.domain.Client;
import com.investec.transactions.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByClientName(String clientName);

    Transaction findByClientNameAndTransactionAmount(String name, String amount);


}
