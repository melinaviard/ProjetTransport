package com.adaming.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IClientRepository;
import com.adaming.entity.Client;
/**
 * 
 * @author IN-LY-023
 *
 */


@Service
public class ClientServiceImpl implements IClientService {

	
	@Autowired
	IClientRepository clientRepository;
	
	public ClientServiceImpl(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	public Client save(Client client)  {
		return  clientRepository.save(client);
	}
	
	public Client update(Client client) {
		return  this.clientRepository.save(client);
	}
	
	public void delete(Client client) {
		clientRepository.delete(client);
	}
	
	public Client findById(Integer id) {
		Optional<Client> client = clientRepository.findById(id);
	   return (client == null ? null : client.orElse(null));
	}
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public List<Client> findByPrenomAndNom(String prenom, String nom) {
		return clientRepository.findByPrenomAndNom(prenom, nom);
	
	
	
	
}
	
}