package org.climbing.model.beans.user;
import javax.inject.Named;

@Named("accountBean")
public class Account {
	
	// ==================== Attributs ====================
	
	private Integer idAccount;
	private String email;
	private String password;
	
	// ==================== Getters/Setters ====================
	
	public Integer getIdAccount() {
		return idAccount;
	}
	
	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [idAccount=" + idAccount + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
