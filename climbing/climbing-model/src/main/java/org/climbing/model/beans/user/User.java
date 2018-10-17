package org.climbing.model.beans.user;

import java.util.Date;

public class User {
	
	// ==================== Attributs ====================
	
	private Integer idUser;
	private String pseudo;
	private String firstName;
	private String lastName;
	private String climbingType;
	private Date birthYear;
	private String sexe;
	private Account account;
	private String role;
	
	// ==================== Getters/Setters ====================

	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getClimbingType() {
		return climbingType;
	}
	public void setClimbingType(String climbingType) {
		this.climbingType = climbingType;
	}
	public Date getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(Date birthYear) {
		this.birthYear = birthYear;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}
