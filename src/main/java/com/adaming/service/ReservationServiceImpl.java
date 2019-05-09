package com.adaming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IClientRepository;
import com.adaming.dao.IReservationRepository;
import com.adaming.dao.IVehiculeRepository;
import com.adaming.entity.Client;
import com.adaming.entity.Reservation;
import com.adaming.entity.Vehicule;



@Service
public class ReservationServiceImpl implements IReservationService {

	
	@Autowired
	IReservationRepository reservationRepository;
	
	@Autowired
	IClientRepository clientRepository;
	
	@Autowired
	IVehiculeRepository vehiculeRepository;
	
	public ReservationServiceImpl(IReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	/**
     * Sauvegarder une reservation.
     * 
     * @param La reservation a sauvegarder
     * 
     * @Return La reservation sauvegardée
     */
	public Reservation saveReservation(Reservation reservation) {
		Client client = reservation.getClient();
		Vehicule vehicule = reservation.getVehicule();
		reservation.setClient(client);
		reservation.setVehicule(vehicule);
		reservation = this.reservationRepository.save(reservation);
		return  reservation;
	}
	
	/**
     * Mettre à jour une reservation.
     * 
     * @param La reservation a mettre à jour
     * 
     */
	public Reservation updateReservation(Reservation reservation) {
		return  null;
	}
	
	/**
     * Effacer une reservation.
     * 
     * @param La reservation a supprimer
     * 
     */
	public void deleteReservation(Reservation reservation) {
		reservationRepository.delete(reservation);
	}
	
	
	/**
     * Trouver une reservation selon son id.
     * 
     * @param L'id de la réservation à trouver.
     * 
     * @Return La reservation recherchée si elle est trouvée. 
     */
	public Reservation findById_reservation(Integer id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		return (reservation == null ? null : reservation.orElse(null));
	}
	
	/**
     * Afficher la liste de toutes les réservations
     * 
     * 
     * @Return La liste à afficher.
     */
	public List<Reservation> findAllReservation() {
		return reservationRepository.findAll();
	}


	/**
     * Trouver une reservation par l'id du véhicule associé
     * 
     * @param L'id du véhicule
     * 
     * @Return La reservation ayant le vehicule correspondant à l'id
     */
	public Reservation findReservationByVehicule(Integer id_vehicule) {
		return reservationRepository.findReservationByVehicule(id_vehicule);
	}
	
	/**
     * Trouver une reservation selon le nom du client
     * 
     * @param Le nom du client
     * 
     * @Return La reservation associée.
     */
	public Reservation findReservationByClient(String username) {
		return reservationRepository.findReservationByClient(username);
	}
	
	
}
