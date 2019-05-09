package com.adaming.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IEmployeRepository;
import com.adaming.entity.Client;
import com.adaming.entity.Employe;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	IEmployeRepository employeRepository;

	public EmployeServiceImpl (IEmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}

	/**
     * Sauvegarder un employe.
     * 
     * @param L'employe à sauvegarder
     * 
     * @Return L'employe sauvegardé
     */
	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);

	}
	
	/**
     * Mettre à jour un employe.
     * 
     * @param L'employe à mettre à jour
     * 
     * @Return L'employe sauvegardé
     */
	public Employe updateEmploye(Employe employe) {
		return  employeRepository.save(employe);
	}

	/**
     * Supprimer un employe.
     * 
     * @param L'employe à supprimer

     */
	public void deleteEmploye(Employe employe) {
		employeRepository.delete(employe);
	}

	/**
     * Trouver un employe.
     * 
     * @param L'id de l'employe à trouver
     * 
     * @Return L'employe s'il est trouvé
     */
	public Employe findById_employe(Integer id_employe) {
		Optional<Employe> employe = employeRepository.findById(id_employe);
		return (employe == null ? null : employe.orElse(null));
	}



}
