package com.investec.transactions.controller;

import com.investec.transactions.controller.model.ClientModel;
import com.investec.transactions.controller.model.Response;
import com.investec.transactions.controller.model.TransactionModel;
import com.investec.transactions.service.ClientService;
import com.investec.transactions.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @GetMapping("/transaction")

    @ApiOperation(httpMethod = "GET", value = "Retreive Transaction", response = Response.class)
    @ResponseStatus(HttpStatus.FOUND)
    public List<TransactionModel> findTransaction(@RequestParam(required = false, name="name") String firstName){
        return transactionService.retrieveTransactions(firstName);
    }

    @PostMapping("/transaction")
    @ApiOperation(httpMethod = "POST", value = "Create Transaction", response = Response.class)
    @ResponseStatus(HttpStatus.CREATED)
    public Response addTransaction(@RequestBody TransactionModel transactionModel) {
        return transactionService.createTransaction(transactionModel);
    }

    @PutMapping("/transaction")
    @ApiOperation(httpMethod = "PUT", value = "Update Transaction", response = Response.class)
    @ResponseStatus(HttpStatus.OK)
    public Response updateTransaction(@RequestBody TransactionModel transactionModel){
        return transactionService.updateTransaction(transactionModel);
    }

    @DeleteMapping("/transaction")
    @ApiOperation(httpMethod = "DELETE", value = "Remove Transaction", response = Response.class)
    @ResponseStatus(HttpStatus.OK)
    public Response removeTransaction(@RequestBody TransactionModel transactionModel){
        return transactionService.removeTransaction(transactionModel);
    }

}

