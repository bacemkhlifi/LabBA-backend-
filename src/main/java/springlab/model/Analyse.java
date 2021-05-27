package springlab.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;




@Entity

public class Analyse  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id_a;
	private String titre;
	private String description;
	private String date;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	
	 @JoinColumn(name="utilisateur_cin", insertable=true, updatable=true)
	@JsonProperty("utilisateur_cin")
	@JsonIgnoreProperties("utilisateurs")
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
		private Utilisateurs utilisateur;
	
	public int getId_a() {
		return id_a;
	}
	public void setId_a(int id_a) {
		this.id_a = id_a;
	}
	
	public String getTitre() {
		return titre;
	}
	public String getDescription() {
		return description;
	}
	public String getDate() {
		return date;
	}
	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	
	}
	@Override
	public String toString() {
		return "Analyse [ titre=" + titre + ", description=" + description + ", date=" + date
				+ ", utilisateur=" + utilisateur + "]";
	}
	public Analyse(int cin, String titre, String description, String date, Utilisateurs utilisateur) {
		
	
		this.titre = titre;
		this.description = description;
		this.date = date;
		this.utilisateur = utilisateur;
	}
	public Analyse() {
		
	}
	
	
}
