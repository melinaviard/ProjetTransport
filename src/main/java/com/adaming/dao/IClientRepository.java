package com.adaming.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

	/**
     * Trouver une liste de client selon leur nom et leur prenom.
     * 
     * @param String
     * 
     * @Return Une liste de client ayant pour nom et prenom ceux recherché
     */

		public List<Client> findByPrenomAndNom(String prenom, String nom);
	

}
