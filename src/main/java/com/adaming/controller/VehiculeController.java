package com.adaming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entity.Client;
import com.adaming.entity.Reservation;
import com.adaming.entity.Vehicule;
import com.adaming.service.ClientServiceImpl;
import com.adaming.service.IVehiculeService;
import com.adaming.service.VehiculeServiceImpl;

@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

	@Autowired
	IVehiculeService vehiculeService;

	public VehiculeController(VehiculeServiceImpl vehiculeServiceImpl) {
		this.vehiculeService = vehiculeServiceImpl;
	}

	@PostMapping("/addVehicule")
	public ResponseEntity<Vehicule> add(@RequestBody Vehicule Vehicule) {
		Vehicule = this.vehiculeService.save(Vehicule);
		return new ResponseEntity<Vehicule>(Vehicule, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletevehicule/{id_vehicule}")
	public void delete(Vehicule vehicule) {
			vehiculeService.delete(vehicule);
		}
		 

	@PutMapping("/update")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
      
		vehiculeService.save(vehicule);
	    	return vehicule;
        }
	@GetMapping(value = "/all_vehicule")
	public ResponseEntity<List<Vehicule>> getAllVehicules() {
		List<Vehicule> vehicules = this.vehiculeService.findAll();
		return new ResponseEntity<>(vehicules, HttpStatus.OK);
	}

	// Rechercher un vehicule par Id
	@GetMapping("findbyid/{id_vehicule}")
	public ResponseEntity<Optional<Vehicule>> getVehiculeById(@PathVariable int id_vehicule) {
		Vehicule vehicule = this.vehiculeService.findById(id_vehicule);
		return new ResponseEntity<Optional<Vehicule>>(HttpStatus.OK);
	}

//	// Rechercher un vehicule par marque
//	@GetMapping("/findbymarque/{marque}") 
//	public ResponseEntity<List<Vehicule>> getVehiculesByMarque( @PathVariable String marque) {
//		List<Vehicule> vehicules  = this.vehiculeService.findByMarque(marque);
//		return new ResponseEntity<>(vehicules, HttpStatus.OK);
//	}

	// Rechercher un vehicule par type
	@GetMapping("/findbytype/{type}")
	public ResponseEntity<List<Vehicule>> getVehiculesByType( @PathVariable String type) {
		List<Vehicule> vehicules  = this.vehiculeService.findByType(type);
		return new ResponseEntity<>(vehicules, HttpStatus.OK);
	}

	// Rechercher un vehicule par nombrePlaces
	@GetMapping("/findbyplace/{nombrePlaces}")
	public ResponseEntity<List<Vehicule>> getVehiculesByNombrePlaces(@PathVariable int nombrePlaces) {
		List<Vehicule> vehicules = this.vehiculeService.findByNombrePlaces(nombrePlaces);
		return new ResponseEntity<>(vehicules, HttpStatus.OK);
	}

//	// Rechercher un vehicule par marque, type et(ce serait bien de faire et/ou nombrePlaces)
//	@PutMapping("/{find_vehicule}")
//	public ResponseEntity<List<Vehicule>> getVehiculesByMarqueAndOrTypeAndOrNombrePlaces( String marque, String type, int nombrePlaces) {
//		List<Vehicule> vehicules = this.vehiculeService.findByMarqueAndOrTypeAndOrNombrePlaces( marque, type, nombrePlaces);
//		return new ResponseEntity<>(vehicules, HttpStatus.OK);
//	}

	
	
	
	
}