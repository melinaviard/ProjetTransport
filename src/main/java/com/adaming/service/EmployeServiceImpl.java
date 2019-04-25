package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IEmployeRepository;
import com.adaming.entity.Employe;
import com.adaming.entity.Reservation;

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
	return  null;
}

public void deleteEmploye(Employe employe) {
	employeRepository.delete(employe);
}




}
