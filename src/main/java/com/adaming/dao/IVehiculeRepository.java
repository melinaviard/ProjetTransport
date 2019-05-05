package com.adaming.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Integer> {

	public List<Vehicule> findByType(String type);
	
	public List<Vehicule> findByNombrePlaces(int nombrePlaces);
	
	public List<Vehicule> findByMarque(String marque);
	
	public List<Vehicule> findAll();

	public void delete(Vehicule vehicule);

//	public Optional<Vehicule> findById(int id_vehicule);
	
//	public List<Vehicule> findByMarqueAndOrTypeAndOrNombrePlaces( String marque, String type, int nombrePlaces);



}
