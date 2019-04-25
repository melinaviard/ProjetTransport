package com.dao.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.SpringBootRunner;
import com.adaming.dao.IReservationRepository;
import com.adaming.entity.Reservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRunner.class)
public class DaoReservationTest {
    
    @Autowired
    IReservationRepository resaDao;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DaoReservationTest.class);
    
    
	
	@Test
	public void givenEntityRepository_whenSaving(){
		LOGGER.info("-----------------Testing givenEntityRepository_whenSaving Method----------------------");
		Reservation addedReservation= resaDao.save(new Reservation(10,null, null, null, "Lyon", "Paris"));
		LOGGER.info("---------Reservation saved---------");
		LOGGER.info("--------Searching for Reservation------------");
		Reservation foundReservation=resaDao.findById(addedReservation.getId_reservation()).orElse(null);
		LOGGER.info("---------Reservation found-----------------");
		LOGGER.info("-------------Verifying Reservation-------------");
		assertNotNull(foundReservation);
		assertEquals(addedReservation.getId_reservation(), foundReservation.getId_reservation());
		LOGGER.info("-------------Utilisateur verified-----------------");
	}
	    
	
	@Test
	public void givenEntityRepository_whenUpdating() {
		// TODO Auto-generated method stub
		LOGGER.info("-----------------Testing givenEntityRepository_whenUpdating Method----------------------");
		Reservation addedReservation= resaDao.save(new Reservation(10,null, null, null, "Lyon", "Paris"));
		LOGGER.info("---------Changement Reservation---------");
		Reservation foundReservation=resaDao.findById(addedReservation.getId_reservation()).orElse(null);
		assertNotNull(foundReservation);
		addedReservation.setAgenceDebut("Marseille");
		assertNotEquals(addedReservation.getAgenceDebut(), foundReservation.getAgenceDebut());
		LOGGER.info("---------Changed Utilisateur---------");
	
	}
    
    @Test
    public void givenEntityRepository_whenDeleting() {
        // TODO Auto-generated method stub
        LOGGER.info("-----------------Testing givenEntityRepository_whenDeleting Method----------------------");
        Reservation resa = resaDao.save(new Reservation(10,null, null, null, "Lyon", "Paris"));
        resaDao.delete(resa);
        Reservation foundResa=resaDao.findById(resa.getId_reservation()).orElse(null);
        assertNull(foundResa);
        LOGGER.info("---------Deleted resa---------");
        
    }
    
}