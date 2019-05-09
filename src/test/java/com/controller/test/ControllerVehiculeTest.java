package com.controller.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.adaming.controller.VehiculeController;
import com.adaming.entity.Vehicule;
import com.adaming.service.VehiculeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerVehiculeTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerVehiculeTest.class);
	private MvcResult mvcResult;
	private String uri;
	private MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;
	@Mock
	VehiculeServiceImpl vehiculeServiceImpl;
	VehiculeController vehiculeController;

	public ControllerVehiculeTest() {
		this.uri = "/vehicule";
	}
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		vehiculeController = new VehiculeController(vehiculeServiceImpl);
	}

	// Test status for add method
	@Test
	public void should_have_200_status_when_addVehicule_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_addVehicule_is_called test Of VehiculeControllerTest ---------------");
		try {
			Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/addVehicule")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	// Test add method
	@Test
	public void should_use_d_when_addVehicule_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_save_when_addVehicule_is_called test Of VehiculeControllerTest ---------------");
		Vehicule myVehicule = new Vehicule();
		vehiculeController.add(myVehicule);
		verify(vehiculeServiceImpl).save(myVehicule);
	}
	
	// Test status for delete method
	@Test
	public void should_have_200_status_when_deleteVehicule_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_deleteVehicule_is_called test Of VehiculeControllerTest ---------------");
		try {
			Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/deletevehicule/{id_vehicule}")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}
	//Test delete method
	@Test
	public void should_use_delete_when_deleteVehicule_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_delete_when_deleteVehicule_is_called test Of VehiculeControllerTest ---------------");
		Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
		vehiculeController.add(myVehicule);
		vehiculeController.delete(myVehicule);
		verify(vehiculeServiceImpl).delete(myVehicule);
	}
	
	// Test status for update method
	@Test
	public void should_have_200_status_when_updateVehicule_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_updateVehicule_is_called test Of VehiculeControllerTest ---------------");
		try {
			Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/update")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}
	// Test update method
	@Test
	public void should_use_update_when_updateVehicule_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_update_when_updateVehicule_is_called test Of VehiculeControllerTest ---------------");
		Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
		vehiculeController.add(myVehicule);
		vehiculeController.updateVehicule(myVehicule);
		verify(vehiculeServiceImpl).update(myVehicule);
	}
	
	// Test status for FindById
	@Test
	public void should_have_200_status_when_findById_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_findById_is_called test Of VehiculeControllerTest ---------------");
		try {
			Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/{id_vehicule}")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}
	// Test FindById method
	@Test
	public void should_use_update_when_findById_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findById_when_findByIdVehicule_is_called test Of VehiculeControllerTest ---------------");
		Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
		vehiculeController.add(myVehicule);
		vehiculeController.getVehiculeById(myVehicule.getId_vehicule());
		verify(vehiculeServiceImpl).findById(1);
	}
	
	// Test status for FindByMarque
	@Test
	public void should_have_200_status_when_findByMarque_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_findByMarque_is_called test Of VehiculeControllerTest ---------------");
		try {
			Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/{marque}")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}
	// Test FindByMarque method
	@Test
	public void should_use_findByMarque_when_findByMarque_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findByMarque_when_findByMarque_is_called test Of VehiculeControllerTest ---------------");
		Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
		vehiculeController.add(myVehicule);
		vehiculeController.getVehiculesByMarque(myVehicule.getMarque());
		verify(vehiculeServiceImpl).findByMarque("Renault");
	}
	
	//Test status for FindByType
	@Test
	public void should_have_200_status_when_findByType_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_findByType_is_called test Of VehiculeControllerTest ---------------");
		try {
			Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/{type}")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}
	// Test findByType method
	@Test
	public void should_use_findByType_when_findByType_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findByType_when_findByType_is_called test Of VehiculeControllerTest ---------------");
		Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
		vehiculeController.add(myVehicule);
		vehiculeController.getVehiculesByType(myVehicule.getType());
		verify(vehiculeServiceImpl).findByType("Citadine");
	}
	
	
	//Test status for FindByNombrePlaces
	@Test
	public void should_have_200_status_when_findByNombrePlaces_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_findByNombrePlaces_is_called test Of VehiculeControllerTest ---------------");
		try {
			Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/{nombrePlaces}")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}
	// Test FindByNombrePlaces method
	@Test
	public void should_use_findByType_when_findByNombrePlaces_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findByNombrePlaces_when_findByNombrePlaces_is_called test Of VehiculeControllerTest ---------------");
		Vehicule myVehicule = new Vehicule(1,"myTitle","myContent",0, 0,  "hey", true, "hello",0);
		vehiculeController.add(myVehicule);
		vehiculeController.getVehiculesByNombrePlaces(myVehicule.getNombrePlaces());
		verify(vehiculeServiceImpl).findByNombrePlaces(26);
	}
}
