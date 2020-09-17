package com.investec.transactions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {


    @GetMapping("/client")
    public String findClient(){
        return "Get Method";
    }

    @PostMapping("/client")
    public String addClient(){
        return "Post Method";
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
