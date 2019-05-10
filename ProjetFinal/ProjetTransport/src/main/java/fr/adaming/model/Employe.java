package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employe_infos")
public class Employe {
	
	@Id
	@Column(name="id_employe")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_employe;
	private String nom;
	private String prenom;
	private String agence;
	
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employe(int id_employe, String nom, String prenom, String agence) {
		super();
		this.id_employe = id_employe;
		this.nom = nom;
		this.prenom = prenom;
		this.agence = agence;
	}
	
	public Employe(String nom, String prenom, String agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.agence = agence;
	}
	
	public String toString1() {
		return "Employe [ nom=" + nom + ", prenom=" + prenom + ", agence=" + agence + "]";
	}

	@Override
	public String toString() {
		return "Employe [id_employe=" + id_employe + ", nom=" + nom + ", prenom=" + prenom + ", agence=" + agence + "]";
	}


	public int getId_employe() {
		return id_employe;
	}


	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAgence() {
		return agence;
	}


	public void setAgence(String agence) {
		this.agence = agence;
	}
	
	
	

}
