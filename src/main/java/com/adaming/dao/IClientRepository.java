package com.adaming.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

		
		public List<Client> findByPrenomAndNom(String prenom, String nom);
	

}
