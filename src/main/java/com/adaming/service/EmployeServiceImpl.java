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

	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);

	}
	public Employe updateEmploye(Employe employe) {
		return  employeRepository.save(employe);
	}

	public void deleteEmploye(Employe employe) {
		employeRepository.delete(employe);
	}

	public Employe findById_employe(Integer id_employe) {
		Optional<Employe> employe = employeRepository.findById(id_employe);
		return (employe == null ? null : employe.orElse(null));
	}



}
