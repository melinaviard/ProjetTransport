package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IReservationRepository;
import com.adaming.entity.Reservation;



@Service
public class ReservationServiceImpl implements IReservationService {

	
	@Autowired
	IReservationRepository reservationRepository;
	
	public ReservationServiceImpl(IReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	public Reservation saveReservation(Reservation reservation) {
		return  reservationRepository.save(reservation);
	}
	
	public Reservation updateReservation(Reservation reservation) {
		return  null;
	}
	
	public void deleteReservation(Reservation reservation) {
		reservationRepository.delete(reservation);
	}
	
	public Reservation findReservationById(Integer id) {
		return reservationRepository.findById(id).orElse(null);
	}
	
	public List<Reservation> findAllReservation() {
		return reservationRepository.findAll();
	}

	
	public Reservation findReservationByVehicule(Integer id_vehicule) {
		return reservationRepository.findReservationByVehicule(id_vehicule);
	
}
	public Reservation findReservationByClient(String username) {
		return reservationRepository.findReservationByClient(username);
	}

}
