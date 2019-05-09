package com.adaming.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Integer> {

	
	/**
     * Trouver un vehicule selon son type.
     * 
     * @param type du vehicule
     * 
     * @Return List<Vehicule>
     */
	public List<Vehicule> findByType(String type);
	
	
	/**
     * Trouver un vehicule selon le nombre de place.
     * 
     * @param nombre de places du vehicule
     * 
     * @Return List<Vehicule>
     */
	public List<Vehicule> findByNombrePlaces(int nombrePlaces);
	
	
	/**
     * Trouver un vehicule selon sa marque.
     * 
     * @param marque du vehicule
     * 
     * @Return List<Vehicule>
     */
	public List<Vehicule> findByMarque(String marque);
	
	/**
     * Trouver tous les véhicules.
     * 
     * 
     * @Return List<Vehicule>
     */
	public List<Vehicule> findAll();

	/**
     * Supprimer un véhicule.
     * 
     * 
     * @param vehicule
     */
	public void delete(Vehicule vehicule);

//	public Optional<Vehicule> findById(int id_vehicule);
	
//	public List<Vehicule> findByMarqueAndOrTypeAndOrNombrePlaces( String marque, String type, int nombrePlaces);



}
