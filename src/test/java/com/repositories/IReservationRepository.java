package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Reservation;


@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer>{

    
    


    
    
}