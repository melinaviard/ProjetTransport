package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Gestionnaire_infos")
public class Gestionnaire extends Employe {
	@Id
	@Column(name="id_gestionnaire")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_gestionnaire;

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

	public Gestionnaire(int id_gestionnaire) {
		super();
		this.id_gestionnaire = id_gestionnaire;
	}

	@Override
	public String toString() {
		return "Gestionnaire [id_gestionnaire=" + id_gestionnaire + "]";
	}

	public int getId_gestionnaire() {
		return id_gestionnaire;
	}

	public void setId_gestionnaire(int id_gestionnaire) {
		this.id_gestionnaire = id_gestionnaire;
	}

	
	
}
