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
	/**
     * Ajouter un véhicule dans la base de données.
     * 
     * @param vehicule a sauver avec tout ses attributs
     * 
     * @Return vehicule qui est sauvé
     */
	public Vehicule save(Vehicule vehicule) {
		return this.vehiculeRepository.save(vehicule);
	}
	
	//update method
	/**
     * Mettre à jour un véhicule dans la base de données.
     * 
     * @param vehicule a mettre à jour
     * 
     * @Return vehicule qui est sauvé
     */
	public Vehicule update(Vehicule vehicule) {
		return this.vehiculeRepository.save(vehicule);
	}
	//delete method
	/**
     * supprimer un véhicule dans la base de données.
     * 
     * @param vehicule a supprimer
     * 
     *
     */
	public void delete(Vehicule vehicule) {
		this.vehiculeRepository.delete(vehicule);
	}
	
	//findByType method
	/**
     * Trouver les véhicules selon leur type.
     * 
     * @param Type attribué au véhicule
     * 
     * @Return Liste de véhicule correspondant au critère
     */
	public List<Vehicule> findByType(String type) {
		return this.vehiculeRepository.findByType(type);
	}
	
	//findByNombrePlaces method
	/**
     * Trouver les véhicules selon leur nombre de place.
     * 
     * @param Nombre de places attribué au véhicule
     * 
     * @Return Liste de véhicule correspondant au critère
     */
	public List<Vehicule> findByNombrePlaces(int nombrePlaces) {
		return this.vehiculeRepository.findByNombrePlaces(nombrePlaces);
	}
	
	//findByMarque method
	/**
     * Trouver les véhicules selon leur marque.
     * 
     * @param marque attribuée au véhicule
     * 
     * @Return Liste de véhicule correspondant au critère
     */
	public List<Vehicule> findByMarque(String marque) {
		return this.vehiculeRepository.findByMarque(marque);
	}
//	
//	//findByMarqueAndOrTypeAndOrNombrePlaces method
//	public List<Vehicule> findByMarqueAndOrTypeAndOrNombrePlaces(String marque, String type, int nombrePlaces) {
//		return this.vehiculeRepository.findByMarqueAndOrTypeAndOrNombrePlaces( marque,  type,  nombrePlaces);
//	}
	/**
     * Trouver les véhicules selon leur id.
     * 
     * @param id attribué au vehicule
     * 
     * @Return Le vehicule correspondant au critère s'il est présent dans la base de données.
     */
	public Optional<Vehicule> findById(int id_vehicule) {
		return this.vehiculeRepository.findById(id_vehicule);
	}
	
	/**
     * Afficher tous les véhicules.
     * 
     * 
     * @Return La liste de tous les véhicules
     */
	public List<Vehicule> findAll() {
		return this.vehiculeRepository.findAll();
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
