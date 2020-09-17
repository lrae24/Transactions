package com.investec.transactions.controller;

import com.investec.transactions.controller.model.Client;
import com.investec.transactions.repository.ClientRepository;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;


    @GetMapping("/client")
    public String findClient(){
        return "Get Method";
    }

    @PostMapping("/client")
    public String addClient(@RequestBody Client clientRequest){
        com.investec.transactions.domain.Client test = new com.investec.transactions.domain.Client(clientRequest);
        clientRepository.save(test);

        return "";
    }

    @PutMapping("/client")
    public String updateClient(){
        return "Put Method";
    }

    @DeleteMapping("/client")
    public String removeClient(){
        return "Delete Method";
    }


}
