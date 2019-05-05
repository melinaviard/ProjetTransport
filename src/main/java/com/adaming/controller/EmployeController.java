package com.adaming.controller;




	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.adaming.entity.Employe;
import com.adaming.service.IEmployeService;


	@RestController
	@RequestMapping("/employe")
	public class EmployeController {

		
		@Autowired
	    IEmployeService employeService;

	    //Add method
	    @PostMapping(value= "/addemploye")
	    public Employe addEmploye(@RequestBody Employe employe) {
	    	employeService.saveEmploye(employe);
			return employe;
			
	}
	    
	
	    //Update method
	    @PutMapping("/update")
	    public Employe updateEmploye(@RequestBody Employe employe) {
	      
		    	employeService.saveEmploye(employe);
		    	return employe;
	        }
	    
	    
	    @DeleteMapping("/{id_employe}")
	    public void deleteEmploye(@PathVariable Integer id_employe){
	        if(employeService.findById_employe(id_employe)!= null){
	   
	            employeService.deleteEmploye(employeService.findById_employe(id_employe));
	        }
	    }
	}

