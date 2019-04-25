package com.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
	@Table(name = "CLient_infos")
	public class Client {
		
		@Id
		@Column(name="id_client")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id_client;
		private String pseudo;
		private String prenom;
		private String nom;
		private int anneePermis;
		private String adresse;
		private String mail;
		private int telephone;
		
		@ManyToOne
		@JoinColumn(name="id_reservation" )
		private Reservation reservation;
		
		//Getters setters sans id :
		public Client() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Client(String pseudo, String prenom, String nom, int anneePermis, String adresse, String mail,
				int telephone) {
			super();
			this.pseudo = pseudo;
			this.prenom = prenom;
			this.nom = nom;
			this.anneePermis = anneePermis;
			this.adresse = adresse;
			this.mail = mail;
			this.telephone = telephone;
		}
		@Override
		public String toString() {
			return "Client [pseudo=" + pseudo + ", prenom=" + prenom + ", nom=" + nom + ", anneePermis=" + anneePermis
					+ ", adresse=" + adresse + ", mail=" + mail + ", telephone=" + telephone + "]";
		}
		public String getPseudo() {
			return pseudo;
		}
		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getAnneePermis() {
			return anneePermis;
		}
		public void setAnneePermis(int anneePermis) {
			this.anneePermis = anneePermis;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public int getTelephone() {
			return telephone;
		}
		public void setTelephone(int telephone) {
			this.telephone = telephone;
		}
		
		
		// getters setters avec Id :

		public Client(int id_client, String pseudo, String prenom, String nom, int anneePermis, String adresse,
				String mail, int telephone) {
			super();
			this.id_client = id_client;
			this.pseudo = pseudo;
			this.prenom = prenom;
			this.nom = nom;
			this.anneePermis = anneePermis;
			this.adresse = adresse;
			this.mail = mail;
			this.telephone = telephone;
		}
		public int getId_client() {
			return id_client;
		}
		public void setId_client(int id_client) {
			this.id_client = id_client;
		}

		
	


}
