package org.climbing.model.beans.user;

import java.util.Date;

public class User {
	
	// ==================== Attributs ====================
	
	private Integer id_user;
	private String pseudo;
	private String first_name;
	private String last_name;
	private String climbing_type;
	private Date birth_year;
	private String genre;
	private Account compte;
	private String role;
	
	// ==================== Getters/Setters ====================
	
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getClimbing_type() {
		return climbing_type;
	}
	public void setClimbing_type(String climbing_type) {
		this.climbing_type = climbing_type;
	}
	public Date getBirth_year() {
		return birth_year;
	}
	public void setBirth_year(Date birth_year) {
		this.birth_year = birth_year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Account getCompte() {
		return compte;
	}
	public void setCompte(Account compte) {
		this.compte = compte;
	}
	
	

}
