package com.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Reservation;



@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer>{
	
	
	public Reservation findReservationByVehicule(long id);
	
	public Reservation findReservationByClient(String username);
	

}