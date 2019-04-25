package com.controller.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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


import com.adaming.dao.IClientRepository;
import com.adaming.entity.Client;
import com.adaming.service.ClientServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerClientTest {

	
	@Autowired
    private ClientServiceImpl clientService;
    private static final Logger LOGGER = LoggerFactory.getLogger(IClientRepository.class);
    
    @Autowired
    WebApplicationContext webApplicationContext;

    protected MockMvc mvc;
    
    // methode qui va initialiser le mock mvc
    @Before
    public final void setUp() {
    	mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    	MockitoAnnotations.initMocks(this);
    }
    
    protected String uri;
    
    public ControllerClientTest() {
		this.uri = "/client"; // path compte client = /client

	}
    
    protected final String mapToJson(Object obj) throws JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper ();
    	return objectMapper.writeValueAsString(obj);
    }
    
    protected final <T> T mapFromJson (String json, Class<T> clazz)
    throws JsonParseException, JsonMappingException, IOException {
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	return objectMapper.readValue(json,  clazz);
    }
    
    @Test
    public void createEntity() {
    	LOGGER.info("---------- Testing createEntity Method -----------");
		LOGGER.info("---------- Constructing Utilisateur-----------");
		Client client = new Client("Mich","Michel","Dupont",2003,"1 rue des paquerettes 69000 Lyon","mich@mich.com",0102030405);
		
		MvcResult mvcResult;
		try {
			LOGGER.info("---------- Serializing Utilisateur Object -----------");
			String inputJson = this.mapToJson(client); // faire appel au ws qui fait appel au service qui fait appel à la methode qui enregistre dans la bd
			LOGGER.info("---------- Mocking Context WebService and invoking the webService -----------");
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri+"/addclient") // path de la methode du controller
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); // cette emthode accompagnée d'un contenu
			LOGGER.info("---------- Getting HTTP Status-----------");
			int status = mvcResult.getResponse().getStatus();
    		LOGGER.info("---------- Verifying HTTP Status -----------");
    		assertEquals(200, status); //Verifier que statut Http OK
    		LOGGER.info("---------- Searching for client -----------");
    		Client clientFound= clientService.findFirst1ByNomAndNom("Michel", "Dupont"); // pas forcément nécessaire ici 
    		LOGGER.info("---------- Verifying client -----------");
    		assertEquals(clientFound.getNom(), client.getNom()); // pas nécessaire ici (comme au dessus)
		}
		catch (Exception e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
