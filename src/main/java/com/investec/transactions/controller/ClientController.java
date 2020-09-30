package com.investec.transactions.controller;

import com.investec.transactions.controller.model.ClientModel;
import com.investec.transactions.controller.model.Response;
import com.investec.transactions.service.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/client")
    @ApiOperation(httpMethod = "GET", value = "Retreive Client", response = ClientModel.class)
    @ResponseStatus(HttpStatus.FOUND)
    public String findClient(@RequestParam(required = false, name="name") String firstName, @RequestParam(required = false, name="idNumber") String idNumber, @RequestParam(required = false, name="mobileNumber") String mobileNumber){
        return clientService.retrieveClient(firstName,idNumber,mobileNumber);
    }

    @PostMapping("/client")
    @ApiOperation(httpMethod = "POST", value = "Create Client", response = Response.class)
    @ResponseStatus(HttpStatus.CREATED)
    public String addClient(@RequestBody @Valid ClientModel clientModel) {
        Response response = clientService.saveClient(clientModel);
      return response.getMessage();
    }

    @PutMapping("/client")
    @ApiOperation(httpMethod = "PUT", value = "Update Client", response = Response.class)
    @ResponseStatus(HttpStatus.OK)
    public Response updateClient(@RequestBody  @Valid ClientModel client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/client")
    @ApiOperation(httpMethod = "DELETE", value = "Remove Client", response = Response.class)
    @ResponseStatus(HttpStatus.OK)
    public Response removeClient( @RequestParam(required = false, name="mobileNumber") String mobileNumber){
     return  clientService.removeClient(mobileNumber);
    }


}
