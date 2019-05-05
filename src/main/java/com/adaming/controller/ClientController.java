package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entity.Client;
import com.adaming.service.ClientServiceImpl;
import com.adaming.service.IClientService;
import com.adaming.entity.Vehicule;

/**
 * 
 * @author IN-LY-023
 *
 */

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	IClientService clientService;
	
	public ClientController(ClientServiceImpl clientServiceImpl) {
		this.clientService = clientServiceImpl;
	}

	//Get method
	@GetMapping(value = "/all_client")
	public List<Client> findAll() {
		return clientService.findAll();
	}

	//add method
		@PostMapping("/addclient")
	public Client save(@RequestBody Client client) {
	       clientService.save(client);
	        return client;
	}

	//Update method
		@PutMapping("/update")
	    public Client updateClient(@RequestBody Client client) {
	      
			clientService.save(client);
		    	return client;
	        }
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Integer id) {
			if(clientService.findById(id)!=null) {
				clientService.delete(clientService.findById(id));
			}
		}
	
	@GetMapping("/findByName")
	public  ResponseEntity<List<Client>> findByPrenomAndNom(@RequestBody String prenom, @RequestBody String nom){			
	List<Client> clients = this.clientService.findByPrenomAndNom(prenom, nom);
	return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	

	
}
