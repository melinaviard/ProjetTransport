package com.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Gestionnaire_infos")
public class Gestionnaire extends Employe {
	

	public Gestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gestionnaire(int id_employe, String nom, String prenom, String agence) {
		super(id_employe, nom, prenom, agence);
		// TODO Auto-generated constructor stub
	}

	public Gestionnaire(String nom, String prenom, String agence) {
		super(nom, prenom, agence);
		// TODO Auto-generated constructor stub
	}



	


	
	
}
