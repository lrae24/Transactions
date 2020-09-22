package com.investec.transactions.controller;

import com.investec.transactions.controller.model.ClientModel;
import com.investec.transactions.controller.model.Response;
import com.investec.transactions.controller.model.TransactionModel;
import com.investec.transactions.service.ClientService;
import com.investec.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @GetMapping("/transaction")
    public List<TransactionModel> findTransaction(@RequestParam(required = false, name="name") String firstName){
        return transactionService.retrieveTransactions(firstName);
    }

    @PostMapping("/transaction")
    public Response addTransaction(@RequestBody TransactionModel transactionModel) {
        return transactionService.createTransaction(transactionModel);
    }

    @PutMapping("/transaction")
    public Response updateTransaction(@RequestBody TransactionModel transactionModel){
        return transactionService.updateTransaction(transactionModel);
    }

    @DeleteMapping("/transaction")
    public Response removeTransaction(@RequestBody TransactionModel transactionModel){
        return transactionService.removeTransaction(transactionModel);
    }

}

