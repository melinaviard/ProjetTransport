package com.adaming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.adaming.entity.Vehicule;

public interface IVehiculeService {

	public Vehicule save(Vehicule vehicule);

	public Vehicule update(Vehicule vehicule);
	
	public void delete(Vehicule vehicule);
	public List<Vehicule> findByType(String type);
	public List<Vehicule> findByNombrePlaces(int nombrePlaces);
	public List<Vehicule> findByMarque(String marque);
//	public List<Vehicule> findByMarqueAndOrTypeAndOrNombrePlaces( String marque, String type, int nombrePlaces);
	public Optional<Vehicule> findById(int id_vehicule);
	public List<Vehicule> findAll();


	}
	