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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name = "Reservation_infos")
public class Reservation implements Serializable{
	
	@Id
	@Column(name="id_reservation")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_reservation;
	private Date dateResa; // La date � laquelle a �t� effectu�e la resa (= "date today")
	private Date dateDebut;
	private Date dateFin;
	private String agenceDebut;
	private String agenceFin;
	
	// 1 client peut avoir plusieurs reservations
	@OneToMany(cascade=CascadeType.ALL, mappedBy="reservation",fetch=FetchType.LAZY )		
	List<Client> projets=new ArrayList<Client>();
	
	// 1 reservation concerne 1 vehicule
	@OneToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="id_vehicule")
	Vehicule vehicule;
	
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reservation(int id_reservation, Date dateResa, Date dateDebut, Date dateFin, String agenceDebut,
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
	public Reservation( Date dateResa, Date dateDebut, Date dateFin, String agenceDebut,
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


	public Date getDateResa() {
		return dateResa;
	}


	public void setDateResa(Date dateResa) {
		this.dateResa = dateResa;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
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
