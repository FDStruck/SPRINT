package com.sprint_4.crm.service;

import java.util.List;

import com.sprint_4.crm.exception.ClientNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint_4.crm.model.Client;
import com.sprint_4.crm.repository.ClientRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    //create single client
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    //create list client
    public List<Client> createListClient(List<Client> client) {
        return clientRepository.saveAll(client);
    }

    //return all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null)
            return client;
        else
            throw new ClientNotFoundException("Não existe este user " + id);
    }

    public Client updateClient(Client client) throws ClientNotFoundException {
        if (!clientRepository.existsById(client.getClientID())) {
            throw new ClientNotFoundException("Client not found with id: " + client.getClientID());
        }
        return clientRepository.save(client);
    }


    public ResponseEntity<String> deleteClient(long id) {
        if (!clientRepository.existsById(id)) {
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
        clientRepository.deleteById(id);
        return new ResponseEntity<>("Client deleted", HttpStatus.OK);
    }


//    public Client getClientByName(String clientName) {
//        return clientRepository.findByNome(clientName);
//    }

}
