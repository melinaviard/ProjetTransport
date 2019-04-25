package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entity.Reservation;
import com.adaming.service.ReservationServiceImpl;

@RestController 
@RequestMapping("/reservation")
@CrossOrigin(origins="http://localhost:8034")
public class ReservationController {


	@Autowired
	ReservationServiceImpl reservationService;

	@GetMapping(value="/all")
	public List<Reservation> findAll(){
		return reservationService.findAllReservation();
	}

	@PostMapping(value="/addreservation",
			consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reservation addNewReservation(@RequestBody Reservation reservation){
		System.out.println(reservation.getId_reservation());
		return this.reservationService.saveReservation(reservation);
	}
	@PutMapping("/{id}")
	public Reservation updateReservation (@RequestBody Reservation reservation, @PathVariable Integer id) {
		if(reservationService.findReservationById(id)==null) {
			return null;
		}
		else {
			return reservationService.saveReservation(reservation);
		}
	}
	
	@PutMapping("/{nom_user}")
	public Reservation updatefReservation (@RequestBody Reservation reservation, @PathVariable String nom_user) {
		if(reservationService.findReservationByClient(nom_user)==null) {
			return null;
		}
		else {
			return reservationService.saveReservation(reservation);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable Integer id) {
		if(reservationService.findReservationById(id)!=null) {
			reservationService.deleteReservation(reservationService.findReservationById(id));
		}
	}


}

