package com.sprint_4.crm.controller;

import java.util.List;

import com.sprint_4.crm.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprint_4.crm.model.Client;
import com.sprint_4.crm.service.ClientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

	private ClientService clientService;
	
	  @PostMapping("/addClients")
	  public ResponseEntity<Client> createClient(@RequestBody Client client) {
	    Client createdClient = clientService.createClient(client);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
	  }
	  
	  @PostMapping("/addListClients")
	  public List<Client> createListClient(@RequestBody List<Client> client) {
	    return clientService.createListClient(client);
	  }
	  
	  @GetMapping("/getClients")
	  public ResponseEntity<List<Client>> getAllClients(){
		return ResponseEntity.ok(clientService.getAllClients());
	  }

	@GetMapping("/getClients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Long id) throws ClientNotFoundException {
		return ResponseEntity.ok(clientService.getClient(id));
	}

	@PutMapping("/update")
	public ResponseEntity<Client> updateClient(@RequestBody Client client) throws ClientNotFoundException {
		return ResponseEntity.ok(clientService.updateClient(client));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable long id) {
		return clientService.deleteClient(id);
	}

	@GetMapping("/getClients/name/{name}")
	public ResponseEntity<Client> getClient(@PathVariable String name) {
		return ResponseEntity.ok(clientService.getClientByName(name));
	}

}
