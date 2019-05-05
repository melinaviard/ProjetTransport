package com.adaming.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IVehiculeRepository;
import com.adaming.entity.Vehicule;
@Service
public class VehiculeServiceImpl implements IVehiculeService {

	@Autowired
	IVehiculeRepository vehiculeRepository;

	
	public VehiculeServiceImpl(IVehiculeRepository vehiculeRepository) {
		this.vehiculeRepository = vehiculeRepository;
	}
		// save method
	public Vehicule save(Vehicule vehicule) {
		return this.vehiculeRepository.save(vehicule);
	}
	
	//update method
	public Vehicule update(Vehicule vehicule) {
		return this.vehiculeRepository.save(vehicule);
	}
	//delete method
	public void delete(Vehicule vehicule) {
		this.vehiculeRepository.delete(vehicule);
	}
	
	//findByType method
	public List<Vehicule> findByType(String type) {
		return this.vehiculeRepository.findByType(type);
	}
	
	//findByNombrePlaces method
	public List<Vehicule> findByNombrePlaces(int nombrePlaces) {
		return this.vehiculeRepository.findByNombrePlaces(nombrePlaces);
	}
	
	//findByMarque method
	public List<Vehicule> findByMarque(String marque) {
		return this.vehiculeRepository.findByMarque(marque);
	}
//	
//	//findByMarqueAndOrTypeAndOrNombrePlaces method
//	public List<Vehicule> findByMarqueAndOrTypeAndOrNombrePlaces(String marque, String type, int nombrePlaces) {
//		return this.vehiculeRepository.findByMarqueAndOrTypeAndOrNombrePlaces( marque,  type,  nombrePlaces);
//	}
	
//	public Optional<Vehicule> findById(int id_vehicule) {
//		return this.vehiculeRepository.findById(id_vehicule);
//	}
	
	public List<Vehicule> findAll() {
		return this.vehiculeRepository.findAll();
				}
	
	@Override
	public Vehicule findById(int id_vehicule) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public Optional<Vehicule> findById(int id_vehicule) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	public List<Vehicule> findByMarqueAndOrTypeAndOrNombrePlaces(String marque, String type, int nombrePlaces) {
//	return this.vehiculeRepository.findByMarqueAndOrTypeAndOrNombrePlaces( marque,  type,  nombrePlaces);

	
	
	
//	@Override
//	public List<Vehicule> findByMarqueAndOrTypeAndOrNombrePlaces(String marque, String type, int nombrePlaces) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

	
}
