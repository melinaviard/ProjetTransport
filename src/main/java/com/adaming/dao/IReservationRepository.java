package com.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Reservation;



@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer>{
	
	/**
     * Trouver une reservation selon l'id de son vehicule.
     * 
     * @param id du vehicule associé à la reservation
     * 
     * @Return une reservation dont le vehicule a l'id recherché
     */
	public Reservation findReservationByVehicule(long id);
	
	
	/**
     * Trouver une reservation selon le nom de son client.
     * 
     * @param le nom du client qui a reservé
     * 
     * @Return reservation dont le client a le nom recherché
     */
	public Reservation findReservationByClient(String username);
	

} 
