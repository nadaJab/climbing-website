package beans.user;

public class Account {
	
	// ==================== Attributs ====================
	
	private Integer id_compte;
	private String email;
	private String password;
	
	// ==================== Getters/Setters ====================
	
	public Integer getId_compte() {
		return id_compte;
	}
	public void setId_compte(Integer id_compte) {
		this.id_compte = id_compte;
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
	
	
}
