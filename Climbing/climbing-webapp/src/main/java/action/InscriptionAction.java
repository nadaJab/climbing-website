package action;
import com.opensymphony.xwork2.ActionSupport;

public class InscriptionAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String firstName;
	private String nomUtilisation;
	//private String DateDeNaissance;
	private String sexe;
	private String typeGrimpe;
	private String email;
	private String password;
	private String confirmerPassword;
	
	public String execute() {
		return SUCCESS;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getNomUtilisation() {
		return nomUtilisation;
	}

	public void setNomUtilisation(String nomUtilisation) {
		this.nomUtilisation = nomUtilisation;
	}
/*
	public String getDateDeNaissance() {
		return DateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	} */

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTypeGrimpe() {
		return typeGrimpe;
	}

	public void setTypeGrimpe(String typeGrimpe) {
		this.typeGrimpe = typeGrimpe;
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

	public String getConfirmerPassword() {
		return confirmerPassword;
	}

	public void setConfirmerPassword(String confirmerPassword) {
		this.confirmerPassword = confirmerPassword;
	}
	
	
}
