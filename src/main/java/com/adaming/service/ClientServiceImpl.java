package com.adaming.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IClientRepository;
import com.adaming.entity.Client;


@Service
public abstract class ClientServiceImpl implements IClientService {

	
	@Autowired
	IClientRepository clientRepository;
	
	public ClientServiceImpl(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	public Client save(Client client) {
		return  clientRepository.save(client);
	}
	
	public Client update(Client client) {
		return  null;
	}
	
	public void delete(Client client) {
		clientRepository.delete(client);
	}
	
	public Client findById(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client findFirst1ByNomAndNom(String prenom, String nom) {
		return clientRepository.findFirst1ByNomAndNom(prenom, nom);
	}
	
	
}
