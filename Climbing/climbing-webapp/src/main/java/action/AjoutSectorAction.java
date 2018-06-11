package action;
import com.opensymphony.xwork2.ActionSupport;

public class AjoutSectorAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameSector;
	private int nbRoutes;
	
	public String execute() {
		return SUCCESS;	
	}

	public String getNameSector() {
		return nameSector;
	}

	public void setNameSector(String nameSector) {
		this.nameSector = nameSector;
	}

	public int getNbRoutes() {
		return nbRoutes;
	}

	public void setNbRoutes(int nbRoutes) {
		this.nbRoutes = nbRoutes;
	}
	
}
