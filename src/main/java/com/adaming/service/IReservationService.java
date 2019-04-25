package com.adaming.service;

import java.util.List;

import com.adaming.entity.Reservation;



public interface IReservationService {

	
	
	public Reservation saveReservation(Reservation reservation);
	
	public Reservation updateReservation(Reservation reservation);
	
	public void deleteReservation(Reservation reservation);
	
	public Reservation findReservationById(Integer id);
	
	public Reservation findReservationByVehicule(Integer id_vehicule);
	
	public List<Reservation> findAllReservation();
	
	
	
}


