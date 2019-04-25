package com.dao.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.SpringBootRunner;
import com.adaming.entity.Reservation;
import com.repositories.IReservationRepository;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRunner.class)
public class DaoTest {
    
    @Autowired
    IReservationRepository resaDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(DaoTest.class);
    
    
    @Test
    public void givenEntityRepository_whenDeleting() {
        // TODO Auto-generated method stub
        LOGGER.info("-----------------Testing givenEntityRepository_whenDeleting Method----------------------");
        Reservation resa = resaDao.save(new Reservation(1,null, null, null, "Lyon", "Paris"));
        resaDao.delete(resa);
        Reservation foundResa=resaDao.findById(resa.getId_reservation()).orElse(null);
        assertNull(foundResa);
        LOGGER.info("---------Deleted resa---------");
        
    }
    
}