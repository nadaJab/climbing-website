package action;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameSpot;
	private String Ville;
	private String pays;
	
	public String execute() {
		return SUCCESS;	
	}

	public String getNameSpot() {
		return nameSpot;
	}

	public void setNameSpot(String nameSpot) {
		this.nameSpot = nameSpot;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
