package com.investec.transactions.service;

import com.investec.transactions.controller.model.Response;
import com.investec.transactions.controller.model.TransactionModel;
import com.investec.transactions.domain.Client;
import com.investec.transactions.domain.Transaction;
import com.investec.transactions.repository.ClientRepository;
import com.investec.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ClientRepository clientRepository;

    public Response createTransaction(TransactionModel transaction){
      Client user =  clientRepository.findByFirstName(transaction.getClientName());
      if(user == null){
          return new Response("Failed to create transaction the client does not exist");
      } else{
          transactionRepository.save(new Transaction(transaction,user));
      }
      return new Response("Transaction created Successfully");
    }

    public List<TransactionModel> retrieveTransactions(String clientName){
      List<TransactionModel> transactionListResponse = null;
      List<Transaction> transactions =  transactionRepository.findByClientName(clientName);
      for(Transaction t: transactions){
          transactionListResponse.add(new TransactionModel(t));
      }
      return  transactionListResponse;
    }


    public Response updateTransaction(TransactionModel transaction) {
        Optional<Transaction> savedTransaction = transactionRepository.findById(transaction.getTransactionId());
        if (savedTransaction == null) {
            return new Response("Could not find treansaction to update");
        } else {
            transactionRepository.save(savedTransaction.get());
        }
        return new Response("Transaction successfully updated");
    }

    public Response removeTransaction(TransactionModel transaction){
        Optional<Transaction> savedTransaction = transactionRepository.findById(transaction.getTransactionId());
        if (savedTransaction == null) {
            return new Response("Could not find treansaction to update");
        } else{
            transactionRepository.deleteById(transaction.getTransactionId());
        }
        return new Response("Transaction successfully deleted");

    }
}
