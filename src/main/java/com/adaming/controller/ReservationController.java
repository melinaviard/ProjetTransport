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

import com.adaming.entity.Employe;
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
	
	

	@PutMapping("/updateid")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
      
		reservationService.saveReservation(reservation);
	    	return reservation;
        }

	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable Integer id) {
		if(reservationService.findById_reservation(id)!=null) {
			reservationService.deleteReservation(reservationService.findById_reservation(id));
		}
	}


}
