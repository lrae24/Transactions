package com.investec.transactions.controller;

import com.investec.transactions.controller.model.Client;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {


    @GetMapping("/client")
    public String findClient(){
        return "Get Method";
    }

    @PostMapping("/client")
    public String addClient(@RequestBody Client client){
        return client.toString();
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
