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
	/**
     * Sauvegarder un client dans la base de données.
     * 
     * @param Le client sauvegardé
     * 
     * @Return Le client sauvegardé
     */
	public Client save(Client client)  {
		return  clientRepository.save(client);
	}
	
	/**
     * Mettre à jour un client.
     * 
     * @param Le client à mettre à jour
     * 
     * @Return Le client mis à jour
     */
	public Client update(Client client) {
		return  this.clientRepository.save(client);
	}
	/**
     * supprimer un cliet 
     * @param Le client à supprimer
     * 
     */
	public void delete(Client client) {
		clientRepository.delete(client);
	}
	
	/**
     * Trouver un client selon son id
     * 
     * @param L'id du client à trouver
     * 
     * @Return Le client s'il est trouvé
     */
	public Client findById(Integer id) {
		Optional<Client> client = clientRepository.findById(id);
	   return (client == null ? null : client.orElse(null));
	}
	
	/**
     * Afficher tous les clients
     * 
     * 
     * @Return La liste des client de la base de données
     */
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	/**
     *Trouver un client selon son nom et son prenom
     * 
     * @param Le nom et le prenom à chercher
     * 
     * @Return La liste des client trouvés
     */
	public List<Client> findByPrenomAndNom(String prenom, String nom) {
		return clientRepository.findByPrenomAndNom(prenom, nom);
	
	
	
	
}
	
}