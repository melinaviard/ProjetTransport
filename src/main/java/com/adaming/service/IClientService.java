package com.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adaming.entity.Client;



public interface IClientService {

		
		public Client save(Client client);
		
		public Client update(Client client);
		
		public void delete(Client client);
		
		public Client findById(Integer id);
		
		public List<Client> findAll();
		
		public Client findFirst1ByNomAndNom(String firstName, String lastName);
		
}

