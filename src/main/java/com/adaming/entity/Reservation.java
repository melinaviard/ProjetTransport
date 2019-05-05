package com.adaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "Reservation_infos")
public class Reservation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_reservation")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_reservation;
	private String dateResa; // La date � laquelle a �t� effectu�e la resa (= "date today")
	private String dateDebut;
	private String dateFin;
	private String agenceDebut;
	private String agenceFin;
	
	// 1 client peut avoir plusieurs reservations
	@ManyToOne
	@JoinColumn(name="id_client" )
	private Client client;

	// 1 reservation concerne 1 vehicule
	@ManyToOne	
	@JoinColumn(name="id_vehicule")
	private Vehicule vehicule;
	
	
	public Reservation(int id_reservation, String dateResa, String dateDebut, String dateFin, String agenceDebut,
			String agenceFin, Client client, Vehicule vehicule) {
		super();
		this.id_reservation = id_reservation;
		this.dateResa = dateResa;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.agenceDebut = agenceDebut;
		this.agenceFin = agenceFin;
		this.client = client;
		this.vehicule= vehicule;
	}

		//inserer resa, chercher client puis reservation.setclient chercher de la bd puis save 

	
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reservation(int id_reservation, String dateResa, String dateDebut, String dateFin, String agenceDebut,
			String agenceFin) {
		super();
		this.id_reservation = id_reservation;
		this.dateResa = dateResa;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.agenceDebut = agenceDebut;
		this.agenceFin = agenceFin;
	}
	
	
	// Sans id :
	public Reservation( String dateResa, String dateDebut, String dateFin, String agenceDebut,
			String agenceFin) {
		super();
		this.dateResa = dateResa;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.agenceDebut = agenceDebut;
		this.agenceFin = agenceFin;
	}


	@Override
	public String toString() {
		return "Reservation [id_reservation=" + id_reservation + ", dateResa=" + dateResa + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", agenceDebut=" + agenceDebut + ", agenceFin=" + agenceFin + "]";
	}
	public String toString1() {
		return "Reservation [" + ", dateResa=" + dateResa + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", agenceDebut=" + agenceDebut + ", agenceFin=" + agenceFin + "]";
	}


	public int getId_reservation() {
		return id_reservation;
	}


	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}


	public String getDateResa() {
		return dateResa;
	}


	public void setDateResa(String dateResa) {
		this.dateResa = dateResa;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public String getAgenceDebut() {
		return agenceDebut;
	}


	public void setAgenceDebut(String agenceDebut) {
		this.agenceDebut = agenceDebut;
	}


	public String getAgenceFin() {
		return agenceFin;
	}


	public void setAgenceFin(String agenceFin) {
		this.agenceFin = agenceFin;
	}
	
	
	

}
