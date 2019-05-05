package com.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entity.Employe;

@Repository
public interface IEmployeRepository extends JpaRepository<Employe, Integer> {

	
	
	
}
