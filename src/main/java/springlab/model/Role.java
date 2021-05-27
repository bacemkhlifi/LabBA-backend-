package springlab.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Role implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id_r;
	
	private String role;
	@JsonManagedReference
	@OneToMany(mappedBy ="role",cascade = CascadeType.ALL, orphanRemoval=true)
    Set<Utilisateurs>  utilisateurs= new HashSet<>();
	public int getId_r() {
		return id_r;
	}
	public String getRole() {
		return role;
	}
	public Set<Utilisateurs> getUtilisateurs() {
		return utilisateurs;
	}
	public void setId_r(int id_r) {
		this.id_r = id_r;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setUtilisateurs(Set<Utilisateurs> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	@Override
	public String toString() {
		return "Role [id_r=" + id_r + ", role=" + role + ", utilisateurs=" + utilisateurs + "]";
	}
	public Role(String role, Set<Utilisateurs> utilisateurs) {
		
		this.role = role;
		this.utilisateurs = utilisateurs;
	}
	public Role() {
	
	}
	
}
