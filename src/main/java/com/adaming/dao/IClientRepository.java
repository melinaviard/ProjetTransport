package com.adaming.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

		
		public Client findFirst1ByNomAndNom(String prenom, String nom);
	

}
