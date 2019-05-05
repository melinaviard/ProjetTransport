package com.controller.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.adaming.controller.ClientController;
import com.adaming.dao.IClientRepository;
import com.adaming.entity.Client;
import com.adaming.entity.Vehicule;
import com.adaming.service.ClientServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author IN-LY-023
 *
 */
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerClientTest {


	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerClientTest.class);
	private MvcResult mvcResult;
	private String uri;
	private MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@Mock
	ClientServiceImpl clientServiceImpl;
	ClientController clientController;

	public ControllerClientTest() {
		this.uri = "/client";
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		clientController = new ClientController(clientServiceImpl);
	}

	//Test status for add method
	@Test
	public void should_have_200_status_when_addClient_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_addClient_is_called test Of ControllerTest ---------------");
		try {
			Client myClient = new Client("Mich","Michel","Dupont",2003,"1 rue des paquerettes 69000 Lyon","mich@mich.com",0102030405);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myClient);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/addclient")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	// Test add method
	@Test
	public void should_use_save_when_addClient_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_save_when_addClient_is_called test Of ControllerTest ---------------");
		Client myClient= new Client();
		clientController.save(myClient);
		verify(clientServiceImpl).save(myClient);
	}
	
	
	//Test status for save method
	@Test
	public void should_have_200_status_when_updateClient_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_updateClient_is_called test Of ClientControllerTest ---------------");
		try {
			Client myClient = new Client("Mich","Michel","Dupont",2003,"1 rue des paquerettes 69000 Lyon","mich@mich.com",0102030405);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myClient);
			mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/update/{id}")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}
	
	// Test update method
		@Test
		public void should_use_update_when_updateClient_is_called() {
			LOGGER.info(
					"--------------- Executing should_use_client_when_updateClient_is_called test Of ClientControllerTest ---------------");
			Client myClient = new Client();
			clientController.save(myClient);
			clientController.updateClient(myClient);
			verify(clientServiceImpl).update(myClient);
		}
		
		//Test status for delete method
		@Test
		public void should_have_200_status_when_deleteClient_is_called() {
			LOGGER.info(
					"--------------- Executing should_have_200_status_when_deleteClient_is_called test Of ClientControllerTest ---------------");
			try {
				Client myClient = new Client("Mich","Michel","Dupont",2003,"1 rue des paquerettes 69000 Lyon","mich@mich.com",0102030405);
				ObjectMapper objectMapper = new ObjectMapper();
				String inputJson = objectMapper.writeValueAsString(myClient);
				mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/delete"+"/{id}")
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
				assertEquals(200, mvcResult.getResponse().getStatus());
			} catch (Exception e) {
				LOGGER.error("An exception occured");
				e.printStackTrace();
			}
		}
		
		// Test delete method
			@Test
			public void should_use_delete_when_deleteClient_is_called() {
				LOGGER.info(
						"--------------- Executing should_use_client_when_updateClient_is_called test Of ClientControllerTest ---------------");
				Client myClient = new Client("Mich","Michel","Dupont",2003,"1 rue des paquerettes 69000 Lyon","mich@mich.com",0102030405);
				clientController.save(myClient);
				clientController.deleteClient(myClient);
				verify(clientServiceImpl).delete(myClient);
			}
			
			//Test status for getAll
			@Test
			public void should_have_200_status_when_getAllClient_is_called() {
				LOGGER.info(
						"--------------- Executing should_have_200_status_when_getAllClient_is_called test Of ClientControllerTest ---------------");
				try {
					Client myClient = new Client("Mich","Michel","Dupont",2003,"1 rue des paquerettes 69000 Lyon","mich@mich.com",0102030405);
					ObjectMapper objectMapper = new ObjectMapper();
					String inputJson = objectMapper.writeValueAsString(myClient);
					mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/all_client")
							.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
					assertEquals(200, mvcResult.getResponse().getStatus());
				} catch (Exception e) {
					LOGGER.error("An exception occured");
					e.printStackTrace();
				}
			}
			
			//Test gettAll method
			@Test
			public void should_use_delete_when_getAllClientClient_is_called() {
				LOGGER.info(
						"--------------- Executing should_use_client_when_getAllClientClient_is_called test Of ClientControllerTest ---------------");
				clientController.findAll();
				verify(clientServiceImpl).findAll();
			}
    
    //Test status for findByNomAndNom
			@Test
			public void should_have_200_status_when_findByNomAndNom_is_called() {
				LOGGER.info(
						"--------------- Executing should_have_200_status_when_findByNomAndNom_is_called test Of ClientControllerTest ---------------");
				try {
					Client myClient = new Client("Mich","Michel","Dupont",2003,"1 rue des paquerettes 69000 Lyon","mich@mich.com",0102030405);
					ObjectMapper objectMapper = new ObjectMapper();
					String inputJson = objectMapper.writeValueAsString(myClient);
					mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/findByName")
							.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
					assertEquals(200, mvcResult.getResponse().getStatus());
				} catch (Exception e) {
					LOGGER.error("An exception occured");
					e.printStackTrace();
				}
			}
			//Test findByNomAndNom method
			@Test
			public void should_use_findByNomAndNom_when_findByNomAndNom_is_called() {
				LOGGER.info(
						"--------------- Executing should_use_client_when_findByNomAndNom_is_called test Of ClientControllerTest ---------------");
				Client myClient = new Client("Mich","Michel","Dupont",2003,"1 rue des paquerettes 69000 Lyon","mich@mich.com",0102030405);
				clientController.findByPrenomAndNom(myClient.getNom(),myClient.getPrenom());
				verify(clientServiceImpl).findByPrenomAndNom("Dupont","Michel");
			}
			
			
    
}