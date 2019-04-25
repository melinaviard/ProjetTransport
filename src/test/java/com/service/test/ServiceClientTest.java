package com.service.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.SpringBootRunner;
import com.adaming.dao.IClientRepository;
import com.adaming.entity.Client;
import com.adaming.service.ClientServiceImpl;







@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRunner.class)
public class ServiceClientTest {
	

	//Declarer un logger
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceClientTest.class);

		
	    private ClientServiceImpl clientService;
		
		
	//Creer faux repository 
		
		@Mock
	private IClientRepository clientRepository;
	
	/**
	 * Preparing the class to accept the use of the @Mock annotation
	 */
	@Before
	  public final void setUp() {
	    MockitoAnnotations.initMocks(this);
	   clientService = new ClientServiceImpl(clientRepository) {
	};
	}
	  
	

	// Test que methodes dao sont bien appelées par ce service là
	@Test
	public void should_store_when_save_is_called() { 
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of ClientServiceTest ---------------");
		Client myClient = new Client();
		clientService.add(myClient);
		Mockito.verify(clientRepository).save(myClient); // pour tracker l'objet
	}
	
	@Test
	public void should_update_when_update_is_called() {
		LOGGER.info("--------------- Executing should_update_when_update_is_called test Of UserServiceImplTest ---------------");
		Client myClient = new Client();
		clientService.update(myClient);
		Mockito.verify(clientRepository).save(myClient);
	}
	
	
}
