package com.investec.transactions.service;

import com.investec.transactions.controller.model.ClientModel;
import com.investec.transactions.controller.model.Response;
import com.investec.transactions.controller.model.TransactionModel;
import com.investec.transactions.domain.Client;
import com.investec.transactions.domain.Transaction;
import com.investec.transactions.repository.ClientRepository;
import com.investec.transactions.repository.TransactionRepository;
import com.investec.transactions.utilities.Validations;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    Validations validations;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public Response saveClient(ClientModel client){
        String message = null;

        if(!validations.isIdValid(client.getIdNumber())){
            return new Response( "Please enter a valid SA ID number");
        }

        if(clientRepository.findByIdNumber(client.getIdNumber()) != null){
            return new Response( "You have entered a duplicate ID number");
        }

        if(clientRepository.findByMobileNumber(client.getMobileNumber()) != null){
            return new Response( "You have entered a duplicate mobile number");
        }

        if(!StringUtils.isEmpty(client.getMobileNumber())) {
            if (!validations.isMobileNumberValid(client.getMobileNumber())) {
                return new Response("Please enter a valid mobile number");
            }
        }

        Client user = new Client(client);
        clientRepository.save(user);
        message = "Your Client has been successfully added";
        return new Response(message);
    }

    public String retrieveClient(String firstName, String idNumber, String mobileNumber){
        ClientModel user = null;
        Client dbUser = null;
        Boolean doesuUserHaveTransactions = false;
        if(!StringUtils.isBlank(firstName) && !StringUtils.isBlank(idNumber) && !StringUtils.isBlank(mobileNumber)) {
             dbUser = clientRepository.findByFirstNameAndIdNumberAndMobileNumber(firstName, idNumber, mobileNumber);
        } else if(!StringUtils.isBlank(firstName)) {
            dbUser = clientRepository.findByFirstName(firstName);
        } else if(!StringUtils.isBlank(idNumber)){
            dbUser =clientRepository.findByIdNumber(idNumber);
        } else if(!StringUtils.isBlank(mobileNumber)){
            dbUser = clientRepository.findByMobileNumber(mobileNumber);
        }

        if (dbUser != null) {
            user = new ClientModel(dbUser);
            List<TransactionModel> currentTransactions = new ArrayList<>();
            List<Transaction> allUserTransactions = transactionRepository.findByClientName(firstName);
            if(allUserTransactions.isEmpty()){
                user.setTransaction(null);
            } else {
                 doesuUserHaveTransactions = true;

                for (Transaction t : allUserTransactions) {
                    currentTransactions.add(new TransactionModel(t));
                }
                user.setTransaction(currentTransactions);
            }
        }

        if(doesuUserHaveTransactions){
            return user.toString();
        } else{
            return user.toString2();
        }

    }


    public Response removeClient(String mobileNumber){
      Client user =  clientRepository.findByMobileNumber(mobileNumber);
      clientRepository.deleteById(user.getId());
      return new Response("Client has been deleted");
    }

    public Response updateClient(ClientModel client){
        Client user =  clientRepository.findByMobileNumber(client.getMobileNumber());

        if(user == null){
            return new Response("No Client found to update");
        } else{
            user.setFirstName(client.getFirstName());
            user.setFullName(client.getFullName());
            user.setLastName(client.getLastName());
            user.setIdNumber(client.getIdNumber());
            user.setMobileNumber(client.getMobileNumber());
            user.setPhysicalAddress(client.getPhysicalAddress());
            clientRepository.save(user);
            return new Response("Client Updated Successfully");
        }
    }

}
