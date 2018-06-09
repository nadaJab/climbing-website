package action;
import com.opensymphony.xwork2.ActionSupport;

public class AjoutSiteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nameSpot;
	private int nbRouteTotal;
	private String cotationMin;
	private String cotationMax;
	private String orientation;
	private String typeGrimpe;
	private String pays;
	private String ville;
	
	public String execute() {
		return SUCCESS;	
	}

	public String getNameSpot() {
		return nameSpot;
	}

	public void setNameSpot(String nameSpot) {
		this.nameSpot = nameSpot;
	}

	public int getNbRouteTotal() {
		return nbRouteTotal;
	}

	public void setNbRouteTotal(int nbRouteTotal) {
		this.nbRouteTotal = nbRouteTotal;
	}

	public String getCotationMin() {
		return cotationMin;
	}

	public void setCotationMin(String cotationMin) {
		this.cotationMin = cotationMin;
	}

	public String getCotationMax() {
		return cotationMax;
	}

	public void setCotationMax(String cotationMax) {
		this.cotationMax = cotationMax;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getTypeGrimpe() {
		return typeGrimpe;
	}

	public void setTypeGrimpe(String typeGrimpe) {
		this.typeGrimpe = typeGrimpe;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
}
