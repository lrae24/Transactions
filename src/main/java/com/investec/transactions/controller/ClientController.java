package com.investec.transactions.controller;

import com.investec.transactions.controller.model.ClientModel;
import com.investec.transactions.controller.model.Response;
import com.investec.transactions.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/client")
    public ClientModel findClient(@RequestParam(required = false, name="name") String firstName, @RequestParam(required = false, name="idNumber") String idNumber, @RequestParam(required = false, name="mobileNumber") String mobileNumber){
        return clientService.retrieveClient(firstName,idNumber,mobileNumber);
    }

    @PostMapping("/client")
    public String addClient(@RequestBody ClientModel clientModel) {
        Response response = clientService.isClientModelValid(clientModel);
      return response.getMessage();
    }

    @PutMapping("/client")
    public Response updateClient(ClientModel client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/client")
    public Response removeClient(String idNumber){
     return   clientService.removeClient(idNumber);
    }


}
